package com.bemos.bemogram.feature.forgot_password.vm

import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.use_cases.FirebaseSendPasswordResetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val firebaseSendPasswordResetUseCase: FirebaseSendPasswordResetUseCase
) : ViewModel() {
    fun sendPasswordReset(
        email: String
    ) {
        firebaseSendPasswordResetUseCase.execute(
            email
        )
    }
}