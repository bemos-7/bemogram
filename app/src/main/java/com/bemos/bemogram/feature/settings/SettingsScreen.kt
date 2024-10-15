package com.bemos.bemogram.feature.settings

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.settings.vm.SettingsViewModel
import com.bemos.shared.Constants.NAV_NAME_SIGN_IN

@Composable
fun SettingsScreen(
    navController: NavController
) {
    val viewModel: SettingsViewModel = hiltViewModel()

    SettingsContent(
        signOut = {
            viewModel.signOut()
            navController.navigate(NAV_NAME_SIGN_IN)
        }
    )
}