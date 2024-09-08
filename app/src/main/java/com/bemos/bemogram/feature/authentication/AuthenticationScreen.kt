package com.bemos.bemogram.feature.authentication

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.bemos.bemogram.feature.authentication.vm.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Composable
fun AuthenticationScreen(
    viewModel: AuthenticationViewModel = hiltViewModel()
) {
    AuthenticationContent(
        signIn = {

        },
        signUp = {
            viewModel.signUp(
                username = it.username!!,
                email = it.email,
                password = it.password
            )
        }
    )
}