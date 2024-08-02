package com.pfv.abzagencytesttask.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pfv.abzagencytesttask.ui.navigation.routes.BaseAppRoutes
import com.pfv.abzagencytesttask.ui.screens.splash.SplashScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = BaseAppRoutes.SplashScreen.route
    ){

        composable(
            route = BaseAppRoutes.SplashScreen.route
        ){

            SplashScreen(navController = navHostController)
        }

        composable(
            route = BaseAppRoutes.MainNavGraph.route
        ){
            MainNavigation()
        }
    }
}