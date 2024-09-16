package com.bemos.bemogram.feature.sign_in

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.sign_in.vm.SignInViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_FORGOT_PASSWORD
import com.bemos.bemogram.utils.Constants.NAV_NAME_PROFILE
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_UP

@Composable
fun SignInScreen(
    navController: NavController,
) {
    val signInViewModel: SignInViewModel = hiltViewModel()
    SignInContent(
        signInButton = {
            signInViewModel.signIn(
                email = it.email,
                password = it.password
            )
            navController.navigate(NAV_NAME_PROFILE)
        },
        registerAccount = {
            navController.navigate(NAV_NAME_SIGN_UP)
        },
        forgotPassword = {
            navController.navigate(NAV_NAME_FORGOT_PASSWORD)
        }
    )
}