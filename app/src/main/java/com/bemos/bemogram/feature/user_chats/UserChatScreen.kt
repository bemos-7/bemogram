package com.bemos.bemogram.feature.user_chats

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.user_chats.vm.UserChatViewModel
import com.bemos.domain.model.AndroidNotificationDetailsDomain
import com.bemos.domain.model.AndroidNotificationDomain
import com.bemos.domain.model.ChatUserDomain
import com.bemos.domain.model.MessageUserDomain
import com.bemos.domain.model.NotificationDomain
import com.bemos.domain.model.PushNotificationDomain

@Composable
fun UserChatScreen(
    navController: NavController,
    user: ChatUserDomain
) {
    val viewModel: UserChatViewModel = hiltViewModel()

    val messages by viewModel.messages.collectAsState()
    val userId by viewModel.userId.collectAsState()
    val userDocument by viewModel.userDoc.collectAsState()

    viewModel.listenForMessages(user.chatId)
    Log.d("PushNotificationTest", user.user.username.toString())
    Log.d("messagesListener", messages.toString())

    UserChatContent(
        messagesList = messages,
        sendMessage = { message, userDoc ->
            viewModel.sendMessage(
                message
            )
            Log.d("PushNotificationTest", userDoc.userId.toString())
            viewModel.sendPushNotification(
                PushNotificationDomain(
                    messageUserDomain = MessageUserDomain(
                        token = userDoc.notificationToken.toString(),
                        notificationDomain = NotificationDomain(
                            title = "Message",
                            body = "This is a notification message!",
                        ),
                        android = AndroidNotificationDomain(
                            notification = AndroidNotificationDetailsDomain(
                                title = userDocument?.username ?: "",
                                body = message.text
                            )
                        )
                    )
                )
            )
        },
        onBackIconClick = {
            navController.popBackStack()
        },
        userId = userId,
        chatId = user.chatId,
        user = user
    )
}