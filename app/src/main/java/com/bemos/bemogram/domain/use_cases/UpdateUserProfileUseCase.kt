package com.bemos.bemogram.domain.use_cases

import android.net.Uri
import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import javax.inject.Inject

class UpdateUserProfileUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    fun execute(
        name: String,
        surname: String,
        imageUser: Uri?
    ) {
        repository.updateUserProfile(
            name,
            surname,
            imageUser
        )
    }
}