package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseAuthenticationRepository
import javax.inject.Inject

class FirebaseSendPasswordResetUseCase @Inject constructor(
    private val repository: FirebaseAuthenticationRepository
) {
    fun execute(
        email: String
    ) {
        repository.firebaseSendPasswordReset(email)
    }
}