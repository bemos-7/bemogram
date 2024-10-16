package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseRealtimeDatabaseRepository
import javax.inject.Inject

class CreateChatUseCase @Inject constructor(
    private val repository: FirebaseRealtimeDatabaseRepository
) {
    fun execute(
        firstUserId: String,
        secondUserId: String
    ) {
        repository.createChat(
            firstUserId = firstUserId,
            secondUserId = secondUserId
        )
    }
}