package com.bemos.bemogram.feature.chats

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.chats.vm.ChatsViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_USER_CHAT

@Composable
fun ChatsScreen(
    navController: NavController
) {
    val viewModel: ChatsViewModel = hiltViewModel()

    val chatList by viewModel.userChats.collectAsState()

    ChatsContent(
        chatsList = chatList,
        onChatClick = {
            navController.navigate("${NAV_NAME_USER_CHAT}/$it")
        }
    )
}