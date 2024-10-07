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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bemos.bemogram.R
import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.MessageDomain
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.feature.user_chats.utils.ui.MessageItem
import com.bemos.bemogram.feature.utils.ui.TextFieldCustomNoLabel
import kotlinx.coroutines.launch

@Composable
fun UserChatContent(
    messagesList: List<MessageDomain>,
    sendMessage: (MessageDomain, UserDomain) -> Unit,
    onBackIconClick: () -> Unit,
    userId: String,
    chatId: String,
    user: ChatUserDomain
) {
    var message by remember {
        mutableStateOf("")
    }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            if (messagesList.isNotEmpty()) {
                listState.animateScrollToItem(messagesList.size - 1)
            }
        }
    }

    LaunchedEffect(messagesList) {
        coroutineScope.launch {
            if (messagesList.isNotEmpty()) {
                listState.animateScrollToItem(messagesList.size - 1)
            }
        }
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

                Card(
                    modifier = Modifier
                        .size(40.dp)
                        .align(
                            alignment = Alignment.CenterVertically
                        ),
                    shape = RoundedCornerShape(1000.dp)
                ) {
                    AsyncImage(
                        model = user.user.imageUrl ?: "",
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = user.user.username ?: "",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Status",
                        fontSize = 12.sp,
                    )
                }

            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = 50.dp, bottom = 80.dp)
                .fillMaxSize(),
        ) {
            LazyColumn(
                state = listState
            ) {
                items(items = messagesList) { messageFromList ->
                    MessageItem(
                        message = messageFromList,
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
                TextFieldCustomNoLabel(
                    modifier = Modifier.width(300.dp),
                    value = message,
                    onValueChange = { message = it },
                )
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedButton(
                    modifier = Modifier.size(50.dp),
                    onClick = {
                        sendMessage(
                            MessageDomain(
                                chatId = chatId,
                                text = message,
                                senderId = userId
                            ),
                            user.user
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
            ),
            MessageDomain(
                chatId = "",
                text = "hello, how are you?",
                senderId = "bemos"
            ),
        ),
        sendMessage = { messageDomain, userDomain ->  
            
        },
        onBackIconClick = {},
        "bemos",
        "asjdkfhlqberjqebrg",
        ChatUserDomain(
            user = UserDomain(
                username = "bemos"
            ),
            chatId = ""
        )
    )
}