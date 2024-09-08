package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseAuthenticationRepository
import com.google.firebase.auth.FirebaseAuth
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