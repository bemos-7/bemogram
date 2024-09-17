package com.bemos.bemogram.feature.edit_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.bemos.bemogram.domain.model.UserDomain
import com.bemos.bemogram.feature.utils.ui.TextFieldCustom

@Composable
fun EditProfileContent(
    continueButtonClick: (UserDomain) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }
    var surname by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.size(120.dp),
            shape = RoundedCornerShape(1000.dp)
        ) {

        }

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldCustom(
            value = name,
            onValueChange = { name = it },
            label = {
                Text(
                    text = "Name"
                )
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldCustom(
            value = surname,
            onValueChange = { surname = it },
            label = {
                Text(
                    text = "Surname"
                )
            }
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                continueButtonClick(
                    UserDomain(
                        name = name,
                        surname = surname,
                        imageUrl = ""
                    )
                )
            }
        ) {
            Text(
                text = "Continue"
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview
@Composable
private fun EditProfileContentPreview() {
    EditProfileContent(
        continueButtonClick = {}
    )
}