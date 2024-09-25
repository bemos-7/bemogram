package com.bemos.bemogram.data.firebase

import androidx.compose.runtime.currentComposer
import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.bemogram.domain.model.MessageDomain
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class FirebaseRealtimeDatabaseImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
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

    override fun getUserChats(userId: String, onComplete: (List<String>) -> Unit) {
        val userChatsRef = firebaseDatabase.getReference("users").child(userId).child("chats")
        userChatsRef.get().addOnSuccessListener { dataSnapshot ->
            val chatId = dataSnapshot.children.map { it.key!! }
            onComplete(chatId)
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


}