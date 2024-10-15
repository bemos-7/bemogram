package com.bemos.bemogram.feature.edit_profile.vm

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.use_cases.UpdateUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val updateUserProfileUseCase: UpdateUserProfileUseCase
) : ViewModel() {

    fun updateUserProfile(
        name: String,
        surname: String,
        imageUser: Uri?
    ) = viewModelScope.launch {
        updateUserProfileUseCase.execute(
            name = name,
            surname = surname,
            imageUser = imageUser,
        )
    }

}