package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseAuthenticationRepository
import javax.inject.Inject

class FirebaseSignInUseCase @Inject constructor(
    private val repository: FirebaseAuthenticationRepository
) {
    fun execute(
        email: String,
        password: String
    ) {
        repository.firebaseSignIn(
            email = email,
            password = password
        )
    }
}