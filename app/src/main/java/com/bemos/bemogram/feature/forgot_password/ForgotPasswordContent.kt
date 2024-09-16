package com.bemos.bemogram.feature.forgot_password

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.bemogram.R
import com.bemos.bemogram.feature.utils.emailValidation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordContent(
    sendLoginOtp: (String) -> Unit,
    backButton: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 10.dp
                )
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        )
                        .clickable {
                            backButton()
                        },
                    painter = painterResource(
                        id = R.drawable.round_arrow_circle_left_24
                    ),
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            Icon(
                modifier = Modifier.size(128.dp),
                painter = painterResource(
                    id = R.drawable.round_lock_outline_24
                ),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Trouble Logging In?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Enter your email and" +
                        "we'll send\n you a otp to get back into your\n" +
                        "account.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email"
                        )
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier
                        .width(280.dp),
                    onClick = {
                        sendLoginOtp(email)
                    },
                    shape = RoundedCornerShape(10.dp),
                    enabled = emailValidation(email)
                ) {
                    Text(
                        text = "Send Login Otp"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ForgotPasswordContentPreview() {
    ForgotPasswordContent(
        sendLoginOtp = {},
        backButton = {}
    )
}