package com.pfv.abzagencytesttask.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pfv.abzagencytesttask.ui.navigation.routes.BottomNavRoutes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigation() {

    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavRoutes.UsersBottomItem,
        BottomNavRoutes.AddNewUserBottomItem
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {

            BottomAppBar {

                bottomNavItems.forEach { item ->

                    val isSelected = currentRoute?.hierarchy?.any { it.route == item.route::class.qualifiedName } == true

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {

                            Icon(
                                painter = painterResource(id = item.img),
                                contentDescription = ""
                            )
                        },
                        label = {
                            Text(text = stringResource(id = item.text))
                        }
                    )
                }
            }
        }
    ) {

        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            MainNavGraph(navController = navController)
        }
    }
}