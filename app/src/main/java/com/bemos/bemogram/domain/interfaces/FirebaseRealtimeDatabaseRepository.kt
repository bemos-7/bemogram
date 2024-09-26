package com.bemos.bemogram.domain.interfaces

import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.MessageDomain
import com.bemos.bemogram.domain.model.UserDomain

interface FirebaseRealtimeDatabaseRepository {

    fun createChat(
        firstUserId: String, secondUserId: String
    )

    fun getUserChats(
        userId: String,
        onComplete: (List<ChatUserDomain>) -> Unit
    )

    fun sendMessage(
        message: MessageDomain
    )

    fun listenForMessages(
        chatId: String,
        onNewMessage: (List<MessageDomain>) -> Unit
    )

}