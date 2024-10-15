package com.bemos.bemogram.main_activity.vm

import androidx.lifecycle.ViewModel
import com.bemos.domain.use_cases.GetFCMTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getFCMTokenUseCase: GetFCMTokenUseCase
) : ViewModel() {
    fun getFCMToken(onComplete: (String) -> Unit) {
        getFCMTokenUseCase.execute(onComplete)
    }
}