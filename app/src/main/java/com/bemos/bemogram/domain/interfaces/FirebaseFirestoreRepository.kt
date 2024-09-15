package com.bemos.bemogram.domain.interfaces

import com.bemos.bemogram.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow

interface FirebaseFirestoreRepository {

    suspend fun getUserDocument() : UserDomain?

    suspend fun getAllUsers() : List<UserDomain>

    suspend fun updateUserProfile(name: String, surname: String = "", userImage: String)

}