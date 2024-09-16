package com.bemos.bemogram.feature.profile.vm

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.domain.use_cases.GetUserDocumentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getDocumentUseCase: GetUserDocumentUseCase
) : ViewModel() {

//    private val _userDocument = mutableStateOf<UserDomain?>(null)
//    val userDocument: State<UserDomain?> = _userDocument

    val userDocument = MutableStateFlow<UserDomain?>(
        null
    )

    fun getUserDocument() = viewModelScope.launch {
        try {
            val user = getDocumentUseCase.execute()
            Log.d("userDocument", user?.email ?: "null")
            userDocument.update {
                user
            }
        } catch (e: Exception) {
            Log.d("userDocument", e.toString())
            userDocument.update {
                null
            }
        }
    }
}