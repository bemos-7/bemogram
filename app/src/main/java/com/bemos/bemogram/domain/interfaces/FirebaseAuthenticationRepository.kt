package com.bemos.bemogram.domain.interfaces

interface FirebaseAuthenticationRepository {

    fun firebaseSignUp(
        username: String,
        email: String,
        password: String
    )

    fun firebaseSignIn(
        email: String,
        password: String
    )

    fun firebaseSignOut()

}