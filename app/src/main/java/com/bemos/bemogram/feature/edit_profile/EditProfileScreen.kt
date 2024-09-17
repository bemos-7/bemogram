package com.bemos.bemogram.feature.edit_profile

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.edit_profile.vm.EditProfileViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_PROFILE

@Composable
fun EditProfileScreen(
    navController: NavController
) {
    val viewModel: EditProfileViewModel = hiltViewModel()

    EditProfileContent(
        continueButtonClick = {
            viewModel.updateUserProfile(
                name = it.name.toString(),
                surname = it.surname.toString(),
                imageUser = ""
            )
            navController.navigate(NAV_NAME_PROFILE)
        }
    )

    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
}