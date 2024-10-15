package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.domain.model.MessageDomain
import javax.inject.Inject

class ListenForMessagesUseCase @Inject constructor(
    private val repository: FirebaseRealtimeDatabaseRepository
) {
    fun execute(chatId: String, onNewMessage: (List<MessageDomain>) -> Unit) {
        repository.listenForMessages(
            chatId = chatId,
            onNewMessage = {
                onNewMessage(it)
            }
        )
    }
}