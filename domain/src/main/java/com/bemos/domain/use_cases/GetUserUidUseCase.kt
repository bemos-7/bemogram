package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import javax.inject.Inject

class GetUserUidUseCase @Inject constructor(
    private val firebaseFirestoreRepository: FirebaseFirestoreRepository
) {
    fun execute(): String {
        return firebaseFirestoreRepository.getUserUid()
    }
}