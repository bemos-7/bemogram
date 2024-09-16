package com.bemos.bemogram.feature.sign_up

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
import androidx.compose.ui.unit.sp
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.feature.sign_in.SignInContent
import com.bemos.bemogram.feature.utils.passwordConfirmation
import com.bemos.bemogram.feature.utils.ui.TextFieldCustom

@Composable
fun SignUpContent(
    loginInAccount: () -> Unit,
    signUpButton: (UserDomain) -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordConfirm by remember {
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
            onValueChange = { email = it },
            label = {
                Text(
                    text = "Email"
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldCustom(
            value = username,
            onValueChange = { username = it },
            label = {
                Text(
                    text = "Username"
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldCustom(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = "Password"
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldCustom(
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            label = {
                Text(
                    text = "Confirm password"
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                signUpButton(
                    UserDomain(
                        username = username,
                        email = email,
                        password = password,
                    )
                )
            },
            shape = RoundedCornerShape(10.dp),
            enabled = passwordConfirmation(password, passwordConfirm)
        ) {
            Text(
                text = "Sign Up",
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
                text = "Have an account?",
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier.clickable {
                    loginInAccount()
                },
                text = "Log In",
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
    SignUpContent(
        loginInAccount = {},
        signUpButton = {}
    )
}