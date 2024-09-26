package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseRealtimeDatabaseRepository
import com.bemos.bemogram.domain.model.ChatUserDomain
import javax.inject.Inject

class GetUserChatsUseCase @Inject constructor(
    private val repository: FirebaseRealtimeDatabaseRepository
) {
    fun execute(userId: String, onComplete: (List<ChatUserDomain>) -> Unit) {
        repository.getUserChats(
            userId = userId,
            onComplete = {
                onComplete(it)
            }
        )
    }
}