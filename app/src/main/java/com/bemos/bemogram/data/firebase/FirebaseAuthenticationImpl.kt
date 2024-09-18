package com.bemos.bemogram.data.firebase

import android.util.Log
import com.bemos.bemogram.domain.interfaces.FirebaseAuthenticationRepository
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.utils.Constants
import com.bemos.bemogram.utils.Constants.COLLECTION_NAME_USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject

class FirebaseAuthenticationImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
) : FirebaseAuthenticationRepository {
    override fun isUserAuthenticatedInFirebase(): Boolean {
        return firebaseAuth.currentUser != null
    }

    override fun firebaseSignUp(username: String, email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(
            email,
            password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val userId = firebaseAuth.currentUser?.uid!!
                val obj = UserDomain(
                    userId = userId,
                    username = username,
                    email = email,
                    password = password
                )
                firebaseFirestore
                    .collection(COLLECTION_NAME_USERS)
                    .document(userId)
                    .set(obj)
            } else {
                Log.d("SignUp", "createUserWithEmailAndPassword Failed: ", task.exception)
            }
        }
    }

    override fun firebaseSignIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(
            email,
            password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
            } else {
                Log.d("SignIn", "signInWithEmailAndPassword Failed: ", task.exception)
            }
        }
    }

    override fun firebaseSignOut() {
        firebaseAuth.signOut()
    }
    override fun firebaseSendPasswordReset(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
    }

}