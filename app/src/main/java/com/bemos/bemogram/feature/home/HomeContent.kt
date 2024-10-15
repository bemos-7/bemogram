package com.bemos.bemogram.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bemos.bemogram.feature.home.ui.MiniProfile
import com.bemos.domain.model.UserDomain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    users: List<UserDomain>,
    searchUser: (String) -> Unit,
    onUserClick: (UserDomain) -> Unit
) {
    val search = remember {
        mutableStateOf("")
    }

    val isActivateSearch = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            query = search.value,
            onQueryChange = {
                search.value = it
                searchUser(it)
            },
            onSearch = {
                search.value = it
                searchUser(it)
            },
            placeholder = {
                Text(
                    "search"
                )
            },
            active = isActivateSearch.value,
            onActiveChange = {
                isActivateSearch.value = it
                searchUser("")
            }
        ) {
            LazyColumn {
                items(items = users) {
                    MiniProfile(
                        user = it,
                        onUserClick = onUserClick
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeContentPreview() {
    HomeContent(
        users = listOf(
            UserDomain(
                username = "anton"
            )
        ),
        searchUser = {

        },
        onUserClick = {

        }
    )
}