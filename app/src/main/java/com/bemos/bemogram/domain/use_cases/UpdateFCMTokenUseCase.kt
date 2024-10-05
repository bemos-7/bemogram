package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import javax.inject.Inject

class UpdateFCMTokenUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    fun execute(token: String) {
        repository.updateFCMToken(token)
    }
}