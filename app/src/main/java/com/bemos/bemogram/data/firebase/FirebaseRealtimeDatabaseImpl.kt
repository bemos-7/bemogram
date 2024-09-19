package com.bemos.bemogram.data.firebase

import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.google.firebase.database.FirebaseDatabase

class FirebaseRealtimeDatabaseImpl(
    private val firebaseDatabase: FirebaseDatabase
) : FirebaseRealtimeDatabaseRepository {
    override fun createChat(firstUserId: String, secondUserId: String) {
        val chatsRef = firebaseDatabase.reference.database.getReference("chats")
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

    override fun getUserChats(userId: String) {
        TODO("Not yet implemented")
    }


}