package com.bemos.bemogram.feature.user_chats.vm

import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.model.MessageDomain
import com.bemos.bemogram.domain.use_cases.GetUserUidUseCase
import com.bemos.bemogram.domain.use_cases.ListenForMessagesUseCase
import com.bemos.bemogram.domain.use_cases.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UserChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val listenForMessagesUseCase: ListenForMessagesUseCase,
    private val getUserUidUseCase: GetUserUidUseCase
) : ViewModel() {

    val messages = MutableStateFlow<List<MessageDomain>>(listOf())
    val userId = MutableStateFlow("")

    init {
        getUserUid()
    }

    fun sendMessage(
        message: MessageDomain
    ) {
        sendMessageUseCase.execute(
            message
        )
    }

    private fun getUserUid() {
        val id = getUserUidUseCase.execute()
        userId.update {
            id
        }
    }

    fun listenForMessages(
        chatId: String
    ) {
        listenForMessagesUseCase.execute(
            chatId = chatId,
            onNewMessage = { newMessage ->
                messages.update {
                    newMessage
                }
            }
        )
    }

}