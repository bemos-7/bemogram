package com.bemos.bemogram.feature.sign_up.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.use_cases.FirebaseSignUpUseCase
import com.bemos.bemogram.feature.utils.emailValidation
import com.bemos.bemogram.feature.utils.passwordConfirmation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: FirebaseSignUpUseCase
) : ViewModel() {

    fun signUp(
        username: String,
        email: String,
        password: String
    ) = viewModelScope.launch {
        if (emailValidation(email)) {
            signUpUseCase.execute(
                username = username,
                email = email,
                password = password
            )
        }
    }

}