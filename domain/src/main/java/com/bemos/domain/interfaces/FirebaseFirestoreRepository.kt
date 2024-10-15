package com.bemos.domain.interfaces

import android.net.Uri
import com.bemos.domain.model.UserDomain

interface FirebaseFirestoreRepository {

    fun getUserDocument(onComplete: (UserDomain?) -> Unit)

    fun getAllUsers(onUserList: (List<UserDomain>) -> Unit)

    fun getUserUid() : String

    fun updateUserProfile(name: String, surname: String = "", userImage: Uri?)

    fun updateFCMToken(token: String)

    fun uploadImageToFirebase(imageUri: Uri)

    fun getUserDocumentById(userId: String, onComplete: (UserDomain?) -> Unit)

}