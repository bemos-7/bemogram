package com.bemos.bemogram.domain.interfaces

import com.bemos.bemogram.domain.model.MessageDomain

interface FirebaseRealtimeDatabaseRepository {

    fun createChat(
        firstUserId: String, secondUserId: String
    )

    fun getUserChats(
        userId: String,
        onComplete: (List<String>) -> Unit
    )

    fun sendMessage(
        message: MessageDomain
    )

    fun listenForMessages(
        chatId: String,
        onNewMessage: (List<MessageDomain>) -> Unit
    )

}