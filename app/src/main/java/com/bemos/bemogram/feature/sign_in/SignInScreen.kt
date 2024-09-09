package com.bemos.bemogram.feature.sign_in

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.sign_in.vm.SignInViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_UP

@Composable
fun SignInScreen(
    navController: NavController,
    signInViewModel: SignInViewModel = hiltViewModel()
) {
    SignInContent(
        signInButton = {
            signInViewModel.signIn(
                email = it.email,
                password = it.password
            )
        },
        registerAccount = {
            navController.navigate(NAV_NAME_SIGN_UP)
        }
    )
}