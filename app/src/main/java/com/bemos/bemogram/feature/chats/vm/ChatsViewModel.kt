package com.bemos.bemogram.feature.chats.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.domain.use_cases.GetUserChatsUseCase
import com.bemos.bemogram.domain.use_cases.GetUserDocumentByIdUseCase
import com.bemos.bemogram.domain.use_cases.GetUserUidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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