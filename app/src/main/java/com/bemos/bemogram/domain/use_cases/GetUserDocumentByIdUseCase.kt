package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.bemogram.domain.model.UserDomain
import javax.inject.Inject

class GetUserDocumentByIdUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    fun execute(userId: String, onComplete: (UserDomain?) -> Unit) {
        return repository.getUserDocumentById(userId, onComplete)
    }
}