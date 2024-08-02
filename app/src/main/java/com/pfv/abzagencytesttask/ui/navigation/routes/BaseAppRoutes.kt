package com.pfv.abzagencytesttask.ui.navigation.routes

import com.pfv.abzagencytesttask.R

sealed class BaseAppRoutes(val route: String) {

    object SplashScreen : BaseAppRoutes("splash_screen")
    object UsersScreen : BaseAppRoutes("users_screen")
    object AddNewUserScreen : BaseAppRoutes("add_new_user_screen")

    object MainNavGraph : BaseAppRoutes("main_nav_graph")
}

sealed class BottomNavRoutes(val route: String, val img: Int, val text: Int) {

    object UsersBottomItem : BottomNavRoutes(BaseAppRoutes.UsersScreen.route, R.drawable.ic_users, R.string.users)
    object AddNewUserBottomItem : BottomNavRoutes(BaseAppRoutes.AddNewUserScreen.route, R.drawable.ic_add_user, R.string.sign_up)
}