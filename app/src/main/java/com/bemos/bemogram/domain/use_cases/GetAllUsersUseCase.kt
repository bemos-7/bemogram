package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.bemogram.domain.model.UserDomain
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val firebaseFirestoreRepository: FirebaseFirestoreRepository
) {
    fun execute(onUserList: (List<UserDomain>) -> Unit) {
        return firebaseFirestoreRepository.getAllUsers(onUserList)
    }
}