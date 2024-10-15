package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.domain.model.UserDomain
import javax.inject.Inject

class GetUserDocumentByIdUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    fun execute(userId: String, onComplete: (UserDomain?) -> Unit) {
        return repository.getUserDocumentById(userId, onComplete)
    }
}