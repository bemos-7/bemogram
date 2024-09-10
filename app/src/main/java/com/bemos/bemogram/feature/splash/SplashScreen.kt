package com.bemos.bemogram.feature.splash

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.splash.vm.SplashViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_PROFILE
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_IN

@Composable
fun SplashScreen(
    navController: NavController,
) {
    val splashViewModel: SplashViewModel = hiltViewModel()
    val isUserAuth = splashViewModel.isUserAuth
    object : CountDownTimer(2000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            if (isUserAuth) {
                navController.navigate(NAV_NAME_PROFILE)
            } else {
                navController.navigate(NAV_NAME_SIGN_IN)
            }

        }

    }.start()
    SplashContent()
}