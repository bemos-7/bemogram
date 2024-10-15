package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.domain.model.MessageDomain
import javax.inject.Inject


class SendMessageUseCase @Inject constructor(
    private val repository: FirebaseRealtimeDatabaseRepository
) {
    fun execute(messageDomain: MessageDomain) {
        repository.sendMessage(messageDomain)
    }
}