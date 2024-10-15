package com.bemos.bemogram.feature.forgot_password.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bemos.bemogram.R

@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit,
    confirmButton: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            Text(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
                    .clickable {
                    confirmButton()
                },
                text = "Confirm"
            )
        },
        icon = {
            Icon(
                modifier = Modifier.size(64.dp),
                painter = painterResource(
                    id = R.drawable.round_email_24
                ),
                contentDescription = null
            )
        },
        text = {
            Text(
                text = "An email with a link to replace the password has been sent to your email"
            )
        }
    )
}