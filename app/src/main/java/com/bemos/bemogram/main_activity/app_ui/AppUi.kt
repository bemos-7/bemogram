package com.bemos.bemogram.main_activity.app_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.feature.chats.ChatsScreen
import com.bemos.bemogram.feature.edit_profile.EditProfileScreen
import com.bemos.bemogram.feature.forgot_password.ForgotPasswordScreen
import com.bemos.bemogram.feature.home.HomeScreen
import com.bemos.bemogram.feature.profile.ProfileScreen
import com.bemos.bemogram.feature.settings.SettingsScreen
import com.bemos.bemogram.feature.sign_in.SignInScreen
import com.bemos.bemogram.feature.sign_in.vm.SignInViewModel
import com.bemos.bemogram.feature.sign_up.SignUpScreen
import com.bemos.bemogram.feature.sign_up.vm.SignUpViewModel
import com.bemos.bemogram.feature.splash.SplashScreen
import com.bemos.bemogram.feature.user_profile.UserProfileScreen
import com.bemos.bemogram.utils.Constants.NAV_INTENT_ITEM_USER
import com.bemos.bemogram.utils.Constants.NAV_NAME_CHATS
import com.bemos.bemogram.utils.Constants.NAV_NAME_EDIT_PROFILE
import com.bemos.bemogram.utils.Constants.NAV_NAME_FORGOT_PASSWORD
import com.bemos.bemogram.utils.Constants.NAV_NAME_HOME
import com.bemos.bemogram.utils.Constants.NAV_NAME_PROFILE
import com.bemos.bemogram.utils.Constants.NAV_NAME_SETTINGS
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_IN
import com.bemos.bemogram.utils.Constants.NAV_NAME_SIGN_UP
import com.bemos.bemogram.utils.Constants.NAV_NAME_SPLASH
import com.bemos.bemogram.utils.Constants.NAV_NAME_USER_PROFILE

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NAV_NAME_SPLASH
    ) {
        splash(
            navController = navController
        )
        signUp(
            navController = navController,
        )
        signIn(
            navController = navController,
        )
        forgotPassword(
            navController = navController
        )
        profile(
            navController = navController
        )
        userProfile(
            navController = navController
        )
        editProfile(
            navController = navController
        )
        home(
            navController = navController
        )
        settings(
            navController = navController
        )
        chats(
            navController = navController
        )
    }
}
private fun NavGraphBuilder.splash(
    navController: NavController
) {
    composable(
        route = NAV_NAME_SPLASH
    ) {
        SplashScreen(
            navController = navController
        )
    }
}

private fun NavGraphBuilder.signUp(
    navController: NavController,

) {
    composable(
        route = NAV_NAME_SIGN_UP
    ) {
        SignUpScreen(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.signIn(
    navController: NavController,

) {
    composable(
        route = NAV_NAME_SIGN_IN
    ) {
        SignInScreen(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.forgotPassword(
    navController: NavController
) {
    composable(
        route = NAV_NAME_FORGOT_PASSWORD
    ) {
        ForgotPasswordScreen(
            navController = navController
        )
    }
}

private fun NavGraphBuilder.profile(
    navController: NavController
) {
    composable(
        route = NAV_NAME_PROFILE
    ) {
        ProfileScreen(
            navController = navController
        )
    }
}

private fun NavGraphBuilder.userProfile(
    navController: NavController
) {
    composable(
        route = NAV_NAME_USER_PROFILE
    ) {
        navController.previousBackStackEntry?.savedStateHandle?.get<UserDomain>(NAV_INTENT_ITEM_USER)?.let {
            UserProfileScreen(
                navController,
                it
            )
        }
    }
}

private fun NavGraphBuilder.editProfile(
    navController: NavController
) {
    composable(
        route = NAV_NAME_EDIT_PROFILE
    ) {
        EditProfileScreen(
            navController = navController
        )
    }
}

private fun NavGraphBuilder.home(
    navController: NavController
) {
    composable(
        route = NAV_NAME_HOME
    ) {
        HomeScreen(
            navController
        )
    }
}

private fun NavGraphBuilder.settings(
    navController: NavController
) {
    composable(
        route = NAV_NAME_SETTINGS
    ) {
        SettingsScreen(
            navController
        )
    }
}

private fun NavGraphBuilder.chats(
    navController: NavController
) {
    composable(
        route = NAV_NAME_CHATS
    ) {
        ChatsScreen(
            navController = navController
        )
    }
}