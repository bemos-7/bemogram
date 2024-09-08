package com.bemos.bemogram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bemos.bemogram.feature.authentication.AuthenticationContent
import com.bemos.bemogram.feature.authentication.AuthenticationScreen
import com.bemos.bemogram.feature.authentication.vm.AuthenticationViewModel
import com.bemos.bemogram.ui.theme.BemogramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BemogramTheme {
                val viewModel = hiltViewModel<AuthenticationViewModel>()
                AuthenticationScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}