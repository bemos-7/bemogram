package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.bemogram.domain.model.UserDomain
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val firebaseFirestoreRepository: FirebaseFirestoreRepository
) {
    suspend fun execute(): List<UserDomain> {
        return firebaseFirestoreRepository.getAllUsers()
    }
}