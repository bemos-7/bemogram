package com.bemos.bemogram.feature.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.bemogram.feature.chats.utils.ui.ChatsItem
import com.bemos.domain.model.ChatUserDomain

@Composable
fun ChatsContent(
    chatsList: List<ChatUserDomain>,
    onChatClick: (ChatUserDomain) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                LazyColumn {
                    items(
                       items = chatsList
                    ) { user ->
                        ChatsItem(
                            user = user,
                            onUserClick = onChatClick
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ChatsContentPreview() {
    ChatsContent(
        chatsList = listOf(

        ),
        onChatClick = { userDoc ->

        }
    )
}