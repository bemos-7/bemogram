package com.bemos.domain.interfaces

import com.bemos.domain.model.ChatUserDomain
import com.bemos.domain.model.MessageDomain

interface FirebaseRealtimeDatabaseRepository {

    fun createChat(
        firstUserId: String, secondUserId: String
    )

    fun getUserChats(
        userId: String,
        onComplete: (List<ChatUserDomain>) -> Unit
    )

    fun sendMessage(
        messageUserDomain: MessageDomain
    )

    fun listenForMessages(
        chatId: String,
        onNewMessage: (List<MessageDomain>) -> Unit
    )

}