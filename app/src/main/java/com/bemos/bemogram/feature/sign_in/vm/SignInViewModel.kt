package com.bemos.bemogram.feature.sign_in.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.use_cases.FirebaseSignInUseCase
import com.bemos.bemogram.domain.use_cases.FirebaseSignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: FirebaseSignInUseCase
) : ViewModel() {

    fun signIn(
        email: String,
        password: String
    ) = viewModelScope.launch {
        signInUseCase.execute(
            email = email,
            password = password
        )
    }

}