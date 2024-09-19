package com.bemos.bemogram.feature.profile

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
import com.bemos.bemogram.utils.Constants.NAV_NAME_SETTINGS

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val viewModel: ProfileViewModel = hiltViewModel()
    val userDocument by viewModel.userDocument.collectAsState()

    viewModel.getUserDocument()

    ProfileContent(
        userDocument = userDocument,
        settingsIcon = {
            navController.navigate(NAV_NAME_SETTINGS)
        }
    )

}