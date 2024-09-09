package com.bemos.bemogram.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.bemos.bemogram.feature.sign_in.vm.SignInViewModel
import com.bemos.bemogram.feature.sign_up.vm.SignUpViewModel
import com.bemos.bemogram.main_activity.app_ui.AppUi
import com.bemos.bemogram.ui.theme.BemogramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val signInViewModel = hiltViewModel<SignInViewModel>()
            val signUpViewModel = hiltViewModel<SignUpViewModel>()
            BemogramTheme {
                AppUi(
                    navController = navController,
                    signInViewModel = signInViewModel,
                    signUpViewModel = signUpViewModel
                )
            }
        }
    }
}