package com.bemos.bemogram.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsContent(
    signOut: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    signOut()
                },
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Sign Out",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview
@Composable
private fun SettingsContentPreview() {
    SettingsContent(
        signOut = {}
    )
}