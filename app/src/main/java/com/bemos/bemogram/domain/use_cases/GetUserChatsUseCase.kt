package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import javax.inject.Inject

class GetUserChatsUseCase @Inject constructor(
    private val repository: FirebaseRealtimeDatabaseRepository
) {
    fun execute(userId: String, onComplete: (List<String>) -> Unit) {
        repository.getUserChats(
            userId = userId,
            onComplete = {
                onComplete(it)
            }
        )
    }
}