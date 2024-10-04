package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseCloudMessagingRepository
import javax.inject.Inject

class GetFCMTokenUseCase @Inject constructor(
    private val repository: FirebaseCloudMessagingRepository
) {
    fun execute(onComplete: (String) -> Unit) {
        repository.getFCMToken(onComplete)
    }
}