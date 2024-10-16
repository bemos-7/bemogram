package com.bemos.data.firebase

import android.net.Uri
import android.util.Log
import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.domain.model.UserDomain
import com.bemos.shared.Constants.COLLECTION_NAME_USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject

class FirebaseFirestoreImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
    private val firebaseStorage: FirebaseStorage
) : FirebaseFirestoreRepository {

    override fun getUserDocument(onComplete: (UserDomain?) -> Unit) {
        try {
            val docRef = firestore.collection(COLLECTION_NAME_USERS).document(firebaseAuth.currentUser!!.uid)
            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        val user = document.toObject(UserDomain::class.java)
                        onComplete(user)
                    }
                }
        } catch (e: Exception) {
            Log.d("getUserDocumentError", e.message.toString())
        }

    }

    override fun getAllUsers(onUserList: (List<UserDomain>) -> Unit) {
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
                    onUserList(uniqueModels)
                }
        } catch (e: Exception) {
            Log.d("getAllUsersError", e.message.toString())
        }
    }

    override fun getUserUid(): String {
        return firebaseAuth.currentUser!!.uid
    }

    override fun updateUserProfile(name: String, surname: String, userImage: Uri?) {
        try {
            val user = firebaseAuth.currentUser!!.uid
            val updates = hashMapOf<String, Any>()

            updates["name"] = name
            updates["surname"] = surname

            firestore.collection("users").document(user)
                .update(
                    updates
                )

            userImage?.let {
                uploadImageToFirebase(
                    it
                )
            }
        } catch (e: Exception) {
            Log.d("updateUserError", e.message.toString())
        }
    }

    override fun updateFCMToken(token: String) {
        try {
            val user = firebaseAuth.currentUser!!.uid
            firestore.collection("users")
                .document(user)
                .update("notificationToken", token).addOnSuccessListener {
                    Log.d("UpdateFCMToken", "FCMToken updated successfully")
                }
        } catch (e: Exception) {
            Log.d("updateFCMTokenError", e.message.toString())
        }
    }

    override fun uploadImageToFirebase(imageUri: Uri) {
        try {
            val user = firebaseAuth.currentUser!!.uid
            val imageRef = firebaseStorage.reference.child("images/$user/avatar.jpg")
            imageRef.putFile(imageUri).addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    val downloadUrl = uri.toString()
                    firestore.collection("users").document(user)
                        .update("imageUrl", downloadUrl).addOnSuccessListener {
                            Log.d("uploadImageToFirebase", "Image URL updated successfully")
                        }
                }
            }
        } catch (e: Exception) {
            Log.d("uploadImageToFirebaseError", e.message.toString())
        }
    }

    override fun getUserDocumentById(userId: String, onComplete: (UserDomain?) -> Unit) {
        try {
            val docRef = firestore.collection(COLLECTION_NAME_USERS).document(userId)
            docRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot != null) {
                        val user = documentSnapshot.toObject<UserDomain>()
                        onComplete(user)
                    }
                }
        } catch (e: Exception) {
            Log.d("getUserDocumentByIdError", e.message.toString())
        }
    }
}