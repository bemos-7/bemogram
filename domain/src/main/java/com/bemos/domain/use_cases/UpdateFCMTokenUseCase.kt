package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import javax.inject.Inject


class UpdateFCMTokenUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    fun execute(token: String) {
        repository.updateFCMToken(token)
    }
}