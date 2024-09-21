package com.bemos.bemogram.feature.user_chats

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.bemogram.R
import com.bemos.bemogram.domain.model.MessageDomain
import com.bemos.bemogram.feature.user_chats.utils.ui.MessageItem
import com.bemos.bemogram.feature.utils.ui.TextFieldCustom

@Composable
fun UserChatContent(
    messagesList: List<MessageDomain>,
    sendMessage: (MessageDomain) -> Unit,
    onBackIconClick: () -> Unit,
    userId: String,
    chatId: String
) {
    var message by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            onBackIconClick()
                        },
                    painter = painterResource(
                        id = R.drawable.round_keyboard_arrow_left_24
                    ),
                    contentDescription = null
                )

                Text(
                    text = chatId
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(items = messagesList) {
                    MessageItem(
                        message = it,
                        userId = userId
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextFieldCustom(
                    value = message,
                    onValueChange = { message = it }
                )
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedButton(
                    modifier = Modifier.size(50.dp),
                    onClick = {
                        sendMessage(
                            MessageDomain(
                                chatId = "",
                                text = message,
                                senderId = userId
                            )
                        )
                        message = ""
                    },
                    shape = CircleShape,
                    border = null,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(
                            id = R.drawable.round_subdirectory_arrow_right_24
                        ),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
private fun UserChatContentPreview() {
    UserChatContent(
        messagesList = listOf(
            MessageDomain(
                chatId = "",
                text = "hello",
                senderId = ""
            )
        ),
        sendMessage = {},
        onBackIconClick = {},
        "",
        "asjdkfhlqberjqebrg"
    )
}