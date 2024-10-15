package com.bemos.bemogram.feature.edit_profile

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.edit_profile.vm.EditProfileViewModel
import com.bemos.shared.Constants.NAV_NAME_PROFILE

@Composable
fun EditProfileScreen(
    navController: NavController
) {
    val viewModel: EditProfileViewModel = hiltViewModel()

    EditProfileContent(
        continueButtonClick = {
            viewModel.updateUserProfile(
                name = it.name,
                surname = it.surname,
                imageUser = it.userImage
            )
            navController.navigate(NAV_NAME_PROFILE)
        }
    )
}