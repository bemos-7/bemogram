package com.bemos.bemogram.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bemos.bemogram.feature.sign_in.vm.SignInViewModel
import com.bemos.bemogram.feature.sign_up.vm.SignUpViewModel
import com.bemos.bemogram.main_activity.app_ui.AppUi
import com.bemos.bemogram.main_activity.app_ui.BottomBarScreen
import com.bemos.bemogram.ui.theme.BemogramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BemogramTheme {
                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(
    navController: NavHostController
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile
    )

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