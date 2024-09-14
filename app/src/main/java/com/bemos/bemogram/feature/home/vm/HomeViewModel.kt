package com.bemos.bemogram.feature.home.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.bemogram.domain.interfaces.FirebaseFirestoreRepository
import com.bemos.bemogram.domain.model.UserDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FirebaseFirestoreRepository
) : ViewModel() {

    val allUsers = MutableStateFlow<List<UserDomain>>(emptyList())

    val searchUsers = MutableStateFlow<List<UserDomain>>(emptyList())

    suspend fun getAllUsers() = viewModelScope.launch {
        try {
            val users = repository.getAllUsers()
            allUsers.update {
                users
            }
        } catch (e: Exception) {
            Log.d("getAllUsersError", e.message.toString())
        }

    }

    fun searchUser(
        user: String
    ) {
        if (user.isNotEmpty()) {
            val users = allUsers.value

            searchUsers.update {
                users.filter {
                    it.username?.lowercase()?.startsWith(user.lowercase()) ?: false
                }
            }
        } else {
            searchUsers.update {
                allUsers.value
            }
        }
    }

}