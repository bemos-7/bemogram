package com.bemos.bemogram.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.bemogram.R
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.ui.theme.Nunito

@Composable
fun ProfileContent(
    userDocument: UserDomain?,
    settingsIcon: () -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = userDocument?.username ?: "...",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Nunito,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Row (
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End
                ) {
                    Column(
                        modifier = Modifier.clickable {
                            settingsIcon()
                        }
                    ) {
                        Icon(
                            painterResource(R.drawable.round_density_medium_24),
                            contentDescription = null
                        )
                    }

                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ProfileInfo(userDocument)
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                ) {
                    Text(
                        text = userDocument?.name ?: "..."
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = userDocument?.surname ?: "..."
                    )
                }
            }

        }
    }
}

@Composable
fun ProfileInfo(
    userDocument: UserDomain?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
    ) {
        Card(
            modifier = Modifier.size(100.dp),
            shape = RoundedCornerShape(1000.dp)
        ) {}

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = (userDocument?.publications?.size ?: 0).toString(),
                    fontSize = 30.sp
                )
                Text(
                    text = "Publications",
                    fontFamily = Nunito,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(15.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = (userDocument?.followers?.size ?: 0).toString(),
                    fontSize = 30.sp
                )
                Text(
                    text = "Followers",
                    fontFamily = Nunito,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(15.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = (userDocument?.following?.size ?: 0).toString(),
                    fontSize = 30.sp
                )
                Text(
                    text = "Following",
                    fontFamily = Nunito,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileContentPreview() {
    ProfileContent(
        userDocument = UserDomain(),
        settingsIcon = {}
    )
}