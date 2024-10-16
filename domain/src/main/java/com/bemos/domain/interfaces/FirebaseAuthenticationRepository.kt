package com.bemos.domain.interfaces

interface FirebaseAuthenticationRepository {

    fun isUserAuthenticatedInFirebase() : Boolean

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

    fun firebaseSendPasswordReset(email: String)

}