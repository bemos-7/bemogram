package com.bemos.bemogram.feature.sign_up

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.sign_up.vm.SignUpViewModel
import com.bemos.shared.Constants.NAV_NAME_EDIT_PROFILE
import com.bemos.shared.Constants.NAV_NAME_SIGN_IN

@Composable
fun SignUpScreen(
    navController: NavController,
) {
    val signUpViewModel: SignUpViewModel = hiltViewModel()
    SignUpContent(
        loginInAccount = {
            navController.navigate(NAV_NAME_SIGN_IN)
        },
        signUpButton = {
            signUpViewModel.signUp(
                username = it.username!!,
                email = it.email,
                password = it.password
            )
            navController.navigate(NAV_NAME_EDIT_PROFILE)
        }
    )
}