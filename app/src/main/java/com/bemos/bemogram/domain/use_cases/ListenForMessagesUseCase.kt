package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.bemogram.domain.model.MessageDomain
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