package com.bemos.bemogram.feature.splash.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.use_cases.IsUserAuthenticatedInFirebaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isUserAuthenticatedInFirebaseUseCase: IsUserAuthenticatedInFirebaseUseCase
) : ViewModel() {
    val isUserAuth get() = isUserAuthenticatedInFirebaseUseCase.execute()
}