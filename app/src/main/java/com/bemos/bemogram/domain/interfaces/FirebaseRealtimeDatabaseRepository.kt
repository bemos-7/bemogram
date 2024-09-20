package com.bemos.bemogram.domain.interfaces

interface FirebaseRealtimeDatabaseRepository {

    fun createChat(
        firstUserId: String, secondUserId: String
    )

    fun getUserChats(
        userId: String,
        onComplete: (List<String>) -> Unit
    )

}