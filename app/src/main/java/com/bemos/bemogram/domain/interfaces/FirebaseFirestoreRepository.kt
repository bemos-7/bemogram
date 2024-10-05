package com.bemos.bemogram.domain.interfaces

import android.net.Uri
import com.bemos.bemogram.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow

interface FirebaseFirestoreRepository {

    fun getUserDocument(onComplete: (UserDomain?) -> Unit)

    fun getAllUsers(onUserList: (List<UserDomain>) -> Unit)

    fun getUserUid() : String

    fun updateUserProfile(name: String, surname: String = "", userImage: Uri?)

    fun updateFCMToken(token: String)

    fun uploadImageToFirebase(imageUri: Uri)

    fun getUserDocumentById(userId: String, onComplete: (UserDomain?) -> Unit)

}