package com.bemos.bemogram.feature.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.profile.vm.ProfileViewModel
import com.bemos.shared.Constants.NAV_NAME_CHATS
import com.bemos.shared.Constants.NAV_NAME_SETTINGS

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val viewModel: ProfileViewModel = hiltViewModel()
    val userDocument by viewModel.userDocument.collectAsState()

    ProfileContent(
        userDocument = userDocument,
        settingsIcon = {
            navController.navigate(NAV_NAME_SETTINGS)
        },
        chatsIcon = {
            navController.navigate(NAV_NAME_CHATS)
        }
    )

}