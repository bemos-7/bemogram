package com.bemos.bemogram.feature.profile.vm

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.domain.use_cases.GetFCMTokenUseCase
import com.bemos.bemogram.domain.use_cases.GetUserDocumentUseCase
import com.bemos.bemogram.domain.use_cases.RuStoreGetPushTokenUseCase
import com.bemos.bemogram.domain.use_cases.UpdateFCMTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getDocumentUseCase: GetUserDocumentUseCase,
    private val updateFCMTokenUseCase: UpdateFCMTokenUseCase,
    private val ruStoreGetPushTokenUseCase: RuStoreGetPushTokenUseCase
) : ViewModel() {

//    private val _userDocument = mutableStateOf<UserDomain?>(null)
//    val userDocument: State<UserDomain?> = _userDocument

    val userDocument = MutableStateFlow<UserDomain?>(
        null
    )

    init {
        getUserDocument()
        getToken()
    }

    private fun getUserDocument() {
        try {
            getDocumentUseCase.execute(
                onComplete = { user ->
                    userDocument.update {
                        user
                    }
                }
            )
        } catch (e: Exception) {
            Log.d("userDocument", e.toString())
            userDocument.update {
                null
            }
        }
    }

    private fun getToken() {
        ruStoreGetPushTokenUseCase.execute { pushToken ->
            isTokenCorrect(pushToken)
        }
    }

    private fun updateToken(token: String) {
        updateFCMTokenUseCase.execute(token)
    }

    private fun isTokenCorrect(token: String) {
        getDocumentUseCase.execute { userDoc ->
            if (token != (userDoc?.notificationToken ?: "")) {
                updateToken(token)
            }
        }
    }
}