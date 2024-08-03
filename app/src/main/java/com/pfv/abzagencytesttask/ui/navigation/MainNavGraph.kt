package com.pfv.abzagencytesttask.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.pfv.abzagencytesttask.ui.navigation.routes.BaseAppRoutes
import com.pfv.abzagencytesttask.ui.screens.sign_up.AddNewUserScreen
import com.pfv.abzagencytesttask.ui.screens.users.UsersScreen

@Composable
fun MainNavGraph(
    paddingValues: PaddingValues,
    navController: NavHostController
) {

    NavHost(
        modifier = Modifier
            .padding(bottom = paddingValues.calculateBottomPadding()),
        navController = navController,
        startDestination = BaseAppRoutes.UsersScreen
    ){

        composable<BaseAppRoutes.UsersScreen>(){
            UsersScreen(navController = navController)
        }

        composable<BaseAppRoutes.AddNewUserScreen>(){
            AddNewUserScreen(navController = navController)
        }

//        dialog(
//            route =
//        ){
//
//        }
    }
}