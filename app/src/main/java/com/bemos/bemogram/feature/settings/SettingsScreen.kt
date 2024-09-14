package com.bemos.bemogram.feature.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.settings.vm.SettingsViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_IN

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