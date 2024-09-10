package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.bemogram.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserDocumentUseCase @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) {
    suspend fun execute() : UserDomain? {
        return repository.getUserDocument()
    }
}