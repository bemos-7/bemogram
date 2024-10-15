package com.bemos.bemogram.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bemos.bemogram.main_activity.app_ui.AppUi
import com.bemos.bemogram.main_activity.app_ui.BottomBarScreen
import com.bemos.bemogram.main_activity.utils.permissions.NotificationPermission.RequestNotificationPermission
import com.bemos.bemogram.ui.theme.BemogramTheme
import com.bemos.shared.Constants.NAV_NAME_EDIT_PROFILE
import com.bemos.shared.Constants.NAV_NAME_FORGOT_PASSWORD
import com.bemos.shared.Constants.NAV_NAME_SIGN_IN
import com.bemos.shared.Constants.NAV_NAME_SIGN_UP
import com.bemos.shared.Constants.NAV_NAME_SPLASH
import com.bemos.shared.Constants.NAV_NAME_USER_CHAT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val bottomBarState = remember {
                mutableStateOf(true)
            }
            RequestNotificationPermission(
                onPermissionGranted = {

                },
                onPermissionDenied = {

                }
            )
            BemogramTheme {
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            visible = bottomBarState.value,
                            enter = slideInVertically(initialOffsetY = { it }),
                            exit = slideOutVertically(targetOffsetY = { it }),
                            content = {
                                BottomBar(
                                    navController = navController,
                                    bottomBarState = bottomBarState
                                )
                            }
                        )
                    }
                ) {
                    AppUi(
                        modifier = Modifier.padding(it),
                        navController = navController,
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {
    var selectedItemIndex by remember {
        mutableStateOf(1)
    }
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile
    )

    navController.addOnDestinationChangedListener { _, destination, _ ->
        bottomBarState.value = when (destination.route) {
            NAV_NAME_SPLASH -> false
            NAV_NAME_SIGN_IN -> false
            NAV_NAME_SIGN_UP -> false
            NAV_NAME_FORGOT_PASSWORD -> false
            NAV_NAME_EDIT_PROFILE -> false
            NAV_NAME_USER_CHAT -> false
            else -> true
        }
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = null
                        )
                    }
                }
            )
        }
    }
}