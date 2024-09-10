package com.bemos.bemogram.feature.profile

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bemos.bemogram.feature.profile.vm.ProfileViewModel

@Composable
fun ProfileScreen() {
    val viewModel: ProfileViewModel = hiltViewModel()
    val userDocument by viewModel.userDocument.collectAsState()

    ProfileContent(
        userDocument = userDocument
    )

}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}