package com.bemos.bemogram.feature.chats.vm

import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.domain.use_cases.GetUserChatsUseCase
import com.bemos.bemogram.domain.use_cases.GetUserDocumentByIdUseCase
import com.bemos.bemogram.domain.use_cases.GetUserUidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val getUserChatsUseCase: GetUserChatsUseCase,
    private val getUserDocumentByIdUseCase: GetUserDocumentByIdUseCase,
    private val getUserUidUseCase: GetUserUidUseCase
) : ViewModel() {

    val userChats = MutableStateFlow(listOf(""))
    val userDocument = MutableStateFlow<UserDomain?>(null)
    val userUid = MutableStateFlow("")

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

    fun getUserChats(
        userId: String,
        onComplete: (List<String>) -> Unit
    ) {
        getUserChatsUseCase.execute(
            userId = userId,
            onComplete = {
                onComplete(it)
            }
        )
    }

    suspend fun getUserDocumentById(userId: String) {
        val user = getUserDocumentByIdUseCase.execute(
            userId = userId
        )
        userDocument.update {
            user
        }
    }

    private fun getUserUid() {
        val id = getUserUidUseCase.execute()
        userUid.update {
            id
        }
    }

}