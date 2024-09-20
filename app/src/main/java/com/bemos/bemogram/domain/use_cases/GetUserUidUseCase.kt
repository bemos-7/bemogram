package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import javax.inject.Inject

class GetUserUidUseCase @Inject constructor(
    private val firebaseFirestoreRepository: FirebaseFirestoreRepository
) {
    fun execute(): String {
        return firebaseFirestoreRepository.getUserUid()
    }
}