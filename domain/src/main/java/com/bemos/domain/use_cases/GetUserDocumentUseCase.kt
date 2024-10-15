package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.domain.model.UserDomain
import javax.inject.Inject

class GetUserDocumentUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    fun execute(onComplete: (UserDomain?) -> Unit) {
        return repository.getUserDocument(onComplete)
    }
}