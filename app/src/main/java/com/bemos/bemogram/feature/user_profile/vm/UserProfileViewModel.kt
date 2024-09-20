package com.bemos.bemogram.feature.user_profile.vm

import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.use_cases.CreateChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val createChatUseCase: CreateChatUseCase,
) : ViewModel() {

    fun createChat(
        firstUserId: String,
        secondUserId: String
    ) {
        createChatUseCase.execute(
            firstUserId = firstUserId,
            secondUserId = secondUserId
        )
    }

}