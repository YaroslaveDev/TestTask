package com.pfv.abzagencytesttask.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pfv.abzagencytesttask.ui.navigation.routes.BaseAppRoutes
import com.pfv.abzagencytesttask.ui.screens.sign_up.AddNewUserScreen
import com.pfv.abzagencytesttask.ui.screens.users.UsersScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = BaseAppRoutes.UsersScreen.route
    ){

        composable(
            route = BaseAppRoutes.UsersScreen.route
        ){
            UsersScreen(navController = navController)
        }

        composable(
            route = BaseAppRoutes.AddNewUserScreen.route
        ){
            AddNewUserScreen(navController = navController)
        }
    }
}