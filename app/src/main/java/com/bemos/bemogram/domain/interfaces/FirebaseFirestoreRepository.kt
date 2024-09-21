package com.bemos.bemogram.domain.interfaces

import android.net.Uri
import com.bemos.bemogram.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow

interface FirebaseFirestoreRepository {

    suspend fun getUserDocument() : UserDomain?

    suspend fun getAllUsers() : List<UserDomain>

    fun getUserUid() : String

    suspend fun updateUserProfile(name: String, surname: String = "", userImage: Uri?)

    suspend fun uploadImageToFirebase(imageUri: Uri)

    suspend fun getUserDocumentById(userId: String): UserDomain?

}