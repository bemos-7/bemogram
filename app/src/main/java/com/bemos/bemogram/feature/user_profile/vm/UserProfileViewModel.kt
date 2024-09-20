package com.bemos.bemogram.feature.user_profile.vm

import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.use_cases.CreateChatUseCase
import com.bemos.bemogram.domain.use_cases.GetUserUidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val createChatUseCase: CreateChatUseCase,
    private val getUserUidUseCase: GetUserUidUseCase
) : ViewModel() {

    val userIdFlow = MutableStateFlow("")

    fun createChat(
        firstUserId: String,
        secondUserId: String
    ) {
        createChatUseCase.execute(
            firstUserId = firstUserId,
            secondUserId = secondUserId
        )
    }

    fun getUserUid() {
        val userId = getUserUidUseCase.execute()
        userIdFlow.update {
            userId
        }
    }

}