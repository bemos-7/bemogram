package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseAuthenticationRepository
import javax.inject.Inject

class FirebaseSignUpUseCase @Inject constructor(
    private val firebaseAuthenticationRepository: FirebaseAuthenticationRepository
) {
   fun execute(
       username: String,
       email: String,
       password: String
   ) = firebaseAuthenticationRepository
       .firebaseSignUp(
           username = username,
           email = email,
           password = password
       )

}