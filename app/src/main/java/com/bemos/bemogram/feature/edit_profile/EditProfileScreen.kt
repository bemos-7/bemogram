package com.bemos.bemogram.feature.edit_profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bemos.bemogram.feature.edit_profile.vm.EditProfileViewModel

@Composable
fun EditProfileScreen() {
    val viewModel: EditProfileViewModel = hiltViewModel()
    EditProfileContent()
}