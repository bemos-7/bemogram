package com.bemos.bemogram.feature.chats.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bemos.domain.model.ChatUserDomain
import com.bemos.domain.model.UserDomain
import com.bemos.domain.use_cases.GetUserChatsUseCase
import com.bemos.domain.use_cases.GetUserDocumentByIdUseCase
import com.bemos.domain.use_cases.GetUserUidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val getUserChatsUseCase: GetUserChatsUseCase,
    private val getUserDocumentByIdUseCase: GetUserDocumentByIdUseCase,
    private val getUserUidUseCase: GetUserUidUseCase,
) : ViewModel() {

    val userChats = MutableStateFlow<List<ChatUserDomain>>(listOf())
    private val userDocument = MutableStateFlow<UserDomain?>(null)
    private val userUid = MutableStateFlow("")

    init {
        getUserUid()
        getUserChats(
            userId = userUid.value,
            onComplete = { chats ->
                userChats.update {
                    chats
                }
                Log.d("PushNotificationTest", chats.toString())
            }
        )
    }

    private fun getUserChats(
        userId: String,
        onComplete: (List<ChatUserDomain>) -> Unit
    ) {
        getUserChatsUseCase.execute(
            userId = userId,
            onComplete = {
                onComplete(it)
            }
        )
    }

    private fun getUserUid() {
        val id = getUserUidUseCase.execute()
        userUid.update {
            id
        }
    }

}