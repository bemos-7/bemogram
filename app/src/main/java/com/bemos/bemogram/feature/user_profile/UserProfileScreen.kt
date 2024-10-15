package com.bemos.bemogram.feature.user_profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.user_profile.vm.UserProfileViewModel
import com.bemos.domain.model.UserDomain
import com.bemos.shared.Constants.NAV_NAME_CHATS

@Composable
fun UserProfileScreen(
    navController: NavController,
    userDomain: UserDomain?
) {
    val viewModel: UserProfileViewModel = hiltViewModel()
    val userId by viewModel.userIdFlow.collectAsState()
    viewModel.getUserUid()

    UserProfileContent(
        userDocument = userDomain,
        startMessages = {
            viewModel.createChat(
                firstUserId = userId,
                secondUserId = it.userId!!
            )
            navController.navigate(NAV_NAME_CHATS)
        }
    )

}