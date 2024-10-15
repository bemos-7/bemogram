package com.bemos.bemogram.feature.user_chats.utils.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.domain.model.MessageDomain

@Composable
fun MessageItem(
    messageDomain: MessageDomain,
    userId: String
) {
    if (messageDomain.senderId == userId) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 30.dp, bottomStart = 30.dp, bottomEnd = 20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = messageDomain.text
                    )
                }
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 10.dp, bottomStart = 20.dp, bottomEnd = 30.dp)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = messageDomain.text
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun MessageItemPreview() {
    MessageItem(
        messageDomain = MessageDomain(
            chatId = "",
            text = "hello Pedro",
            senderId = ""
        ),
        userId = ""
    )
}