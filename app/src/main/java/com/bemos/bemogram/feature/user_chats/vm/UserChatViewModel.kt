package com.bemos.bemogram.feature.user_chats.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.model.MessageDomain
import com.bemos.bemogram.domain.model.PushNotification
import com.bemos.bemogram.domain.use_cases.GetUserUidUseCase
import com.bemos.bemogram.domain.use_cases.ListenForMessagesUseCase
import com.bemos.bemogram.domain.use_cases.SendMessageUseCase
import com.bemos.bemogram.domain.use_cases.SendPushNotificationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val listenForMessagesUseCase: ListenForMessagesUseCase,
    private val getUserUidUseCase: GetUserUidUseCase,
    private val sendPushNotificationUseCase: SendPushNotificationUseCase
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

    fun sendPushNotification(
        notification: PushNotification
    ) = viewModelScope.launch {
        val result = sendPushNotificationUseCase.execute(notification)
        result.onSuccess {
            Log.d("NotificationSend", "successfully")

        }.onFailure {
            Log.d("NotificationSend", it.message.toString())
        }
    }

}