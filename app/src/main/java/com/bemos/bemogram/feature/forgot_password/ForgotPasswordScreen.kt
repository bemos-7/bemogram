package com.bemos.bemogram.feature.forgot_password

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.forgot_password.vm.ForgotPasswordViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_IN

@Composable
fun ForgotPasswordScreen(
    navController: NavController
) {
    val viewModel: ForgotPasswordViewModel = hiltViewModel()

    ForgotPasswordContent(
        sendLoginOtp = {
            viewModel.sendPasswordReset(it)
            navController.navigate(NAV_NAME_SIGN_IN)
        },
        backButton = {
            navController.navigate(NAV_NAME_SIGN_IN)
        }
    )
}