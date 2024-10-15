package com.bemos.bemogram.main_activity.utils.permissions

import android.Manifest
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

object NotificationPermission : ComponentActivity() {

    @Composable
    fun RequestNotificationPermission(
        onPermissionGranted: () -> Unit,
        onPermissionDenied: () -> Unit
    ) {
        val notificationPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted ->
                if (isGranted) {
                    onPermissionGranted()
                } else {
                    onPermissionDenied()
                }
            }
        )

        LaunchedEffect(Unit) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                onPermissionGranted()
            }
        }
    }

}