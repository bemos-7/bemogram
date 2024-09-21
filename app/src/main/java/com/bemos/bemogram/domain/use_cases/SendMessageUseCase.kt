package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.bemogram.domain.model.MessageDomain
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: FirebaseRealtimeDatabaseRepository
) {
    fun execute(message: MessageDomain) {
        repository.sendMessage(message)
    }
}