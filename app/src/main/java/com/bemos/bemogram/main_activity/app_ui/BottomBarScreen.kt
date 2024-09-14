package com.bemos.bemogram.main_activity.app_ui

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.bemos.bemogram.utils.Constants.NAV_NAME_HOME
import com.bemos.bemogram.utils.Constants.NAV_NAME_PROFILE

sealed class BottomBarScreen(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean
) {
    object Profile : BottomBarScreen(
        title = NAV_NAME_PROFILE,
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        hasNews = false
    )

    object Home : BottomBarScreen(
        title = NAV_NAME_HOME,
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        hasNews = false
    )
}