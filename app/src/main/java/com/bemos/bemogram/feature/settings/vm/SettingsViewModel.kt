package com.bemos.bemogram.feature.settings.vm

import androidx.lifecycle.ViewModel
import com.bemos.bemogram.domain.use_cases.FirebaseSignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val firebaseSignOutUseCase: FirebaseSignOutUseCase
) : ViewModel() {

    fun signOut() {
        firebaseSignOutUseCase.execute()
    }

}