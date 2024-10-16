package com.bemos.bemogram.feature.chats

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.chats.vm.ChatsViewModel
import com.bemos.shared.Constants.NAV_INTENT_ITEM_USER_INFO
import com.bemos.shared.Constants.NAV_NAME_USER_CHAT

@Composable
fun ChatsScreen(
    navController: NavController
) {
    val viewModel: ChatsViewModel = hiltViewModel()

    val chatList by viewModel.userChats.collectAsState()

    Log.d("chatListErrorTest", chatList.toString())

    ChatsContent(
        chatsList = chatList,
        onChatClick = { userDoc ->
            navController.currentBackStackEntry?.savedStateHandle?.set(NAV_INTENT_ITEM_USER_INFO, userDoc)
            navController.navigate(NAV_NAME_USER_CHAT)
        }
    )
}