package com.bemos.bemogram.feature.authentication.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.use_cases.FirebaseSignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val firebaseSignUpUseCase: FirebaseSignUpUseCase
) : ViewModel() {
    fun signUp(
        username: String,
        email: String,
        password: String
    ) = viewModelScope.launch {
        firebaseSignUpUseCase.execute(
            username = username,
            email = email,
            password = password
        )
    }
}