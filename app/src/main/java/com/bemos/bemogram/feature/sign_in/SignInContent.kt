package com.bemos.bemogram.feature.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.bemogram.feature.utils.passwordConfirmation
import com.bemos.bemogram.feature.utils.ui.TextFieldCustom
import com.bemos.domain.model.UserDomain

@Composable
fun SignInContent(
    signInButton: (UserDomain) -> Unit,
    registerAccount: () -> Unit,
    forgotPassword: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldCustom(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(
                    text = "Email"
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldCustom(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(
                    text = "Password"
                )
            }
        )

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier
                .width(280.dp)
                .clickable {
                    forgotPassword()
                },
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Forgot password?"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                signInButton(
                    UserDomain(
                        email = email,
                        password = password
                    )
                )
            },
            shape = RoundedCornerShape(10.dp),
            enabled = passwordConfirmation(password, password)
        ) {
            Text(
                text = "Sign In"
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "Don't have account?",
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier.clickable {
                    registerAccount()
                },
                text = "Sign up",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "bemogram",
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun SignInContentPreview() {
    SignInContent(
        signInButton = {},
        registerAccount = {},
        forgotPassword = {}
    )
}