package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseAuthenticationRepository
import javax.inject.Inject

class FirebaseSignOutUseCase @Inject constructor(
    private val repository: FirebaseAuthenticationRepository
) {
    fun execute() {
        repository.firebaseSignOut()
    }
}