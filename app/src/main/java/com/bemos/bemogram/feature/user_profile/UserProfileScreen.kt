package com.bemos.bemogram.feature.user_profile

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.feature.profile.vm.ProfileViewModel
import com.bemos.bemogram.feature.user_profile.vm.UserProfileViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_CHATS
import com.bemos.bemogram.utils.Constants.NAV_NAME_SETTINGS
import com.bemos.bemogram.utils.Constants.NAV_NAME_USER_CHAT

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