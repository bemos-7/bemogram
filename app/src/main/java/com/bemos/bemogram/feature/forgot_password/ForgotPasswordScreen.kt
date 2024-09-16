package com.bemos.bemogram.feature.forgot_password

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.R
import com.bemos.bemogram.feature.forgot_password.ui.CustomDialog
import com.bemos.bemogram.feature.forgot_password.vm.ForgotPasswordViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_IN

@Composable
fun ForgotPasswordScreen(
    navController: NavController
) {
    val viewModel: ForgotPasswordViewModel = hiltViewModel()

    var openDialog by remember {
        mutableStateOf(false)
    }
    if (openDialog) {
        CustomDialog(
            onDismissRequest = {
                openDialog = false
                navController.navigate(NAV_NAME_SIGN_IN)
            },
            confirmButton = {
                navController.navigate(NAV_NAME_SIGN_IN)
            }
        )
    }


    ForgotPasswordContent(
        sendLoginOtp = {
            viewModel.sendPasswordReset(it)
            openDialog = true
        },
        backButton = {
            navController.navigate(NAV_NAME_SIGN_IN)
        }
    )
}