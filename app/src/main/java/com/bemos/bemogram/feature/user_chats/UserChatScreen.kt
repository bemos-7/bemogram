package com.bemos.bemogram.feature.user_chats

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.domain.model.AndroidNotification
import com.bemos.bemogram.domain.model.AndroidNotificationDetails
import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.Message
import com.bemos.bemogram.domain.model.Notification
import com.bemos.bemogram.domain.model.PushNotification
import com.bemos.bemogram.feature.user_chats.vm.UserChatViewModel

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
                PushNotification(
                    message = Message(
                        token = userDoc.notificationToken.toString(),
                        notification = Notification(
                            title = "Message",
                            body = "This is a notification message!",
                        ),
                        android = AndroidNotification(
                            notification = AndroidNotificationDetails(
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