package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.domain.model.UserDomain
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val firebaseFirestoreRepository: FirebaseFirestoreRepository
) {
    fun execute(onUserList: (List<UserDomain>) -> Unit) {
        return firebaseFirestoreRepository.getAllUsers(onUserList)
    }
}