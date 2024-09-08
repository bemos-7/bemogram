package com.bemos.bemogram.feature.authentication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.bemogram.domain.model.UserDomain

@Composable
fun AuthenticationContent(
    signIn: (UserDomain) -> Unit,
    signUp: (UserDomain) -> Unit,
) {

    var switch by remember {
        mutableStateOf(true)
    }

    var buttonContent by remember {
        mutableStateOf("sign in")
    }

    var text by remember {
        mutableStateOf("Create account")
    }

    var username by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    if (switch) {
        buttonContent = "Sign Up"
        text = "Sign In"
    } else {
        buttonContent = "Sign In"
        text = "Sign Up"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (switch) {
            TextField(
                value = username,
                onValueChange = {
                    username = it
                }
            )

            Spacer(modifier = Modifier.height(40.dp))
        }

        TextField(
            value = email,
            onValueChange = {
                email = it
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            }
        )

        if (switch) {
            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                }
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
            if (switch) {
                signUp(
                    UserDomain(
                        username = username,
                        email = email,
                        password = confirmPassword
                    )
                )
            } else {
                signIn(
                    UserDomain(
                        email = email,
                        password = confirmPassword
                    )
                )
            }
        }
        ) {
            Text(text = buttonContent)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable {
                switch = !switch
            },
            text = text
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview
@Composable
fun AuthenticationContentPreview() {
    AuthenticationContent(
        signIn = {},
        signUp = {}
    )
}