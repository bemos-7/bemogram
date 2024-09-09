package com.bemos.bemogram.main_activity.app_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bemos.bemogram.feature.sign_in.SignInScreen
import com.bemos.bemogram.feature.sign_in.vm.SignInViewModel
import com.bemos.bemogram.feature.sign_up.SignUpScreen
import com.bemos.bemogram.feature.sign_up.vm.SignUpViewModel
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_IN
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_UP

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    signInViewModel: SignInViewModel,
    signUpViewModel: SignUpViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NAV_NAME_SIGN_IN
    ) {
        signUp(
            navController = navController,
            signUpViewModel = signUpViewModel
        )
        signIn(
            navController = navController,
            signInViewModel = signInViewModel
        )
    }
}

private fun NavGraphBuilder.signUp(
    navController: NavController,
    signUpViewModel: SignUpViewModel
) {
    composable(
        route = NAV_NAME_SIGN_UP
    ) {
        SignUpScreen(
            navController = navController,
            signUpViewModel = signUpViewModel
        )
    }
}

private fun NavGraphBuilder.signIn(
    navController: NavController,
    signInViewModel: SignInViewModel
) {
    composable(
        route = NAV_NAME_SIGN_IN
    ) {
        SignInScreen(
            navController = navController,
            signInViewModel = signInViewModel
        )
    }
}