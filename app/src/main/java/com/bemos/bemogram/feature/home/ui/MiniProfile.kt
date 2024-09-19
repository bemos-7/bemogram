package com.bemos.bemogram.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bemos.bemogram.domain.model.UserDomain

@Composable
fun MiniProfile(
    user: UserDomain,
    onUserClick: (UserDomain) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onUserClick(user)
            }
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.background
                )
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(60.dp),
                shape = RoundedCornerShape(1000.dp)
            ) {
                AsyncImage(
                    model = user.imageUrl,
                    contentDescription = null
                )
            }
            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Text(
                text = user.username ?: ""
            )
        }

    }
}

@Preview
@Composable
private fun MiniProfilePreview() {
    MiniProfile(
        user = UserDomain(
            username = "Andres"
        ),
        onUserClick = {}
    )
}