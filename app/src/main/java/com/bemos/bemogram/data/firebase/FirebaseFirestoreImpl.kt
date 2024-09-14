package com.bemos.bemogram.data.firebase

import android.util.Log
import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.utils.Constants.COLLECTION_NAME_USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseFirestoreImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : FirebaseFirestoreRepository {

    override suspend fun getUserDocument(): UserDomain? = suspendCoroutine { continuation ->
        val docRef = firestore.collection(COLLECTION_NAME_USERS).document(firebaseAuth.currentUser!!.uid)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val user = document.toObject(UserDomain::class.java)
                    continuation.resume(user)
                } else {
                    continuation.resume(null)
                }
            }
            .addOnFailureListener { exception ->
                continuation.resumeWithException(exception = exception)
            }
    }

    override suspend fun getAllUsers(): List<UserDomain> = suspendCancellableCoroutine { continuation ->
        try {
            val docRef = firestore.collection(COLLECTION_NAME_USERS)
            docRef.get()
                .addOnSuccessListener { documents ->
                    val uniqueModels = mutableListOf<UserDomain>()
                    for (document in documents) {
                        val model = document.toObject(UserDomain::class.java)
                        Log.d("testUsers", model.username.toString())
                        if (model != null && !uniqueModels.contains(model)) {
                            uniqueModels.add(
                                model
                            )
                        }
                    }
                    continuation.resume(uniqueModels)
                }
                .addOnFailureListener {
                    continuation.resumeWithException(it)
                }
        } catch (e: Exception) {
            Log.d("Firestore", "Error")
            continuation.resumeWithException(e)
        }
    }

}