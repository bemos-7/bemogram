package com.bemos.bemogram.feature.chats

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.chats.vm.ChatsViewModel

@Composable
fun ChatsScreen(
    navController: NavController
) {
    val viewModel: ChatsViewModel = hiltViewModel()


}