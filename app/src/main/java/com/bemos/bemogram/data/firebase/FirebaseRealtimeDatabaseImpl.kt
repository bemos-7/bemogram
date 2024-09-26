package com.bemos.bemogram.data.firebase

import android.util.Log
import androidx.compose.runtime.currentComposer
import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.MessageDomain
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.utils.Constants.COLLECTION_NAME_USERS
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import javax.inject.Inject

class FirebaseRealtimeDatabaseImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
    private val firestore: FirebaseFirestore
) : FirebaseRealtimeDatabaseRepository {
    override fun createChat(firstUserId: String, secondUserId: String) {
        val chatsRef = firebaseDatabase.getReference("chats")
        val newChatRef = chatsRef.push()
        val chatData = mapOf(
            "participants" to mapOf(firstUserId to true, secondUserId to true)
        )
        newChatRef.setValue(chatData)
            .addOnSuccessListener {
                firebaseDatabase.reference.database
                    .getReference("users")
                    .child(firstUserId)
                    .child("chats")
                    .child(newChatRef.key!!)
                    .setValue(true)

                firebaseDatabase.reference.database
                    .getReference("users")
                    .child(secondUserId)
                    .child("chats")
                    .child(newChatRef.key!!)
                    .setValue(true)
            }
    }

    override fun getUserChats(userId: String, onComplete: (List<ChatUserDomain>) -> Unit) {
        val userChatsRef = firebaseDatabase.getReference("users").child(userId).child("chats")

        userChatsRef.get().addOnSuccessListener { dataSnapshot ->
            val chatIds = dataSnapshot.children.map { it.key!! }
            val chatUserDomains = mutableListOf<ChatUserDomain>()

            if (chatIds.isEmpty()) {
                onComplete(chatUserDomains)
                return@addOnSuccessListener
            }

            var totalRequests = 0
            var completedCount = 0

            chatIds.forEach { chatId ->
                val participantsRef = firebaseDatabase.getReference("chats").child(chatId).child("participants")
                participantsRef.get().addOnSuccessListener { snapshot ->
                    val usersList = snapshot.children.map { it.key!! }
                    totalRequests += usersList.size // Подсчитываем общее количество запросов

                    usersList.forEach { participantId ->
                        if (participantId != userId) {
                            // Получаем данные пользователя из Firestore
                            val userRef = firestore.collection("users").document(participantId)
                            userRef.get().addOnSuccessListener { userSnapshot ->
                                if (userSnapshot.exists()) {
                                    val userDocument = userSnapshot.toObject(UserDomain::class.java)

                                    if (userDocument != null) {
                                        chatUserDomains.add(
                                            ChatUserDomain(
                                                user = userDocument,
                                                chatId = chatId
                                            )
                                        )
                                    }
                                } else {
                                    Log.e("Firestore", "User document not found for participantId: $participantId")
                                }

                                completedCount++
                                if (completedCount == totalRequests) {
                                    onComplete(chatUserDomains) // Вызываем onComplete, когда все запросы завершены
                                }
                            }.addOnFailureListener { e ->
                                Log.e("Firestore", "Error getting user document: $e")
                                completedCount++
                                if (completedCount == totalRequests) {
                                    onComplete(chatUserDomains)
                                }
                            }
                        } else {
                            // Увеличиваем счетчик для участников, если это текущий пользователь
                            completedCount++
                        }
                    }

                    // Если нет участников, вызываем onComplete сразу
                    if (usersList.isEmpty()) {
                        completedCount++
                        if (completedCount == totalRequests) {
                            onComplete(chatUserDomains)
                        }
                    }
                }.addOnFailureListener { e ->
                    Log.e("Realtime", "Error getting participants: $e")
                    onComplete(chatUserDomains) // Завершаем выполнение в случае ошибки
                }
            }
        }.addOnFailureListener { e ->
            Log.e("Realtime", "Error getting user chats: $e")
            onComplete(emptyList()) // Завершаем выполнение в случае ошибки
        }
    }

    override fun sendMessage(message: MessageDomain) {
        val messageRef = firebaseDatabase.getReference("chats").child(message.chatId).child("messages")

        val messages = mapOf(
            "text" to message.text,
            "senderId" to message.senderId,
            "timestamp" to ServerValue.TIMESTAMP
        )
        messageRef.push().setValue(messages)
    }

    override fun listenForMessages(chatId: String, onNewMessage: (List<MessageDomain>) -> Unit) {
        val messagesRef = firebaseDatabase.getReference("chats").child(chatId).child("messages")

        messagesRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messages = snapshot.children.mapNotNull {
                    it.getValue(MessageDomain::class.java)
                }
                onNewMessage(messages)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun getUserDocumentById(userId: String, onComplete: (UserDomain?) -> Unit) {
        try {
            val docRef = firestore.collection(COLLECTION_NAME_USERS).document(userId)
            docRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot != null) {
                        val user = documentSnapshot.toObject<UserDomain>()
                        onComplete(user)
                    }
                }
        } catch (e: Exception) {
            Log.d("getUserDocumentByIdError", e.message.toString())
        }
    }

}