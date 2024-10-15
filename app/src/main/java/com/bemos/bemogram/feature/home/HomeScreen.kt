package com.bemos.bemogram.feature.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.home.vm.HomeViewModel
import com.bemos.shared.Constants.NAV_INTENT_ITEM_USER
import com.bemos.shared.Constants.NAV_NAME_USER_PROFILE

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel: HomeViewModel = hiltViewModel()

    val allUsers by viewModel.allUsers.collectAsState()
    val searchUsers by viewModel.searchUsers.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }

    Log.d("testUsers", allUsers.toString())

    HomeContent(
        searchUsers,
        searchUser = {
            viewModel.searchUser(it)
        },
        onUserClick = {
            navController.currentBackStackEntry?.savedStateHandle?.set(NAV_INTENT_ITEM_USER, it)
            navController.navigate(NAV_NAME_USER_PROFILE)
        }
    )
}