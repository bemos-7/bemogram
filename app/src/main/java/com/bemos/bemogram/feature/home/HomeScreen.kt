package com.bemos.bemogram.feature.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bemos.bemogram.feature.home.vm.HomeViewModel

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
        }
    )
}