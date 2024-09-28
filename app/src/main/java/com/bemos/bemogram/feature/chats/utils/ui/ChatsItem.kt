package com.bemos.bemogram.feature.chats.utils.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bemos.bemogram.domain.model.ChatUserDomain
import com.bemos.bemogram.domain.model.UserDomain

@Composable
fun ChatsItem(
    user: ChatUserDomain,
    onUserClick: (ChatUserDomain) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onUserClick(
                    ChatUserDomain(
                        user = UserDomain(
                            username = user.user.username,
                            imageUrl = user.user.imageUrl
                        ),
                        chatId = user.chatId
                    )
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(60.dp),
                shape = RoundedCornerShape(1000.dp)
            ) {
                AsyncImage(
                    model = user.user.imageUrl,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = user.user.username ?: "",
                fontSize = 18.sp
            )
        }
    }
    Spacer(modifier = Modifier.width(10.dp))
}

@Preview
@Composable
private fun ChatsItemsPreview() {
    ChatsItem(
        user = ChatUserDomain(
            user = UserDomain(),
            chatId = ""
        ),
        onUserClick = {}
    )
}