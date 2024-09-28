package com.bemos.bemogram.feature.user_chats

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.feature.chats.ChatsContent
import com.bemos.bemogram.feature.user_chats.vm.UserChatViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_CHATS

@Composable
fun UserChatScreen(
    navController: NavController,
    user: ChatUserDomain
) {
    val viewModel: UserChatViewModel = hiltViewModel()

    val messages by viewModel.messages.collectAsState()
    val userId by viewModel.userId.collectAsState()

    viewModel.listenForMessages(user.chatId)
    Log.d("messagesListener", messages.toString())

    UserChatContent(
        messagesList = messages,
        sendMessage = {
            viewModel.sendMessage(
                it
            )
        },
        onBackIconClick = {
            navController.navigate(NAV_NAME_CHATS)
        },
        userId = userId,
        chatId = user.chatId,
        user = user
    )
}