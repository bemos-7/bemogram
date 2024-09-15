package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import javax.inject.Inject

class UpdateUserProfileUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    suspend fun execute(
        name: String,
        surname: String,
        imageUser: String
    ) {
        repository.updateUserProfile(
            name,
            surname,
            imageUser
        )
    }
}