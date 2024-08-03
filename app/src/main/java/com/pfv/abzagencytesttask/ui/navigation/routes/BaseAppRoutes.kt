package com.pfv.abzagencytesttask.ui.navigation.routes

import com.pfv.abzagencytesttask.R
import kotlinx.serialization.Serializable

sealed class BaseAppRoutes() {

//    object SplashScreen : BaseAppRoutes("splash_screen")
//    object UsersScreen : BaseAppRoutes("users_screen")
//    object AddNewUserScreen : BaseAppRoutes("add_new_user_screen")
//
//    object MainNavGraph : BaseAppRoutes("main_nav_graph")

    @Serializable
    object SplashScreen : BaseAppRoutes()

    @Serializable
    object UsersScreen : BaseAppRoutes()

    @Serializable
    object AddNewUserScreen : BaseAppRoutes()

    @Serializable
    object MainNavGraph : BaseAppRoutes()

}

sealed class BottomNavRoutes(val route: BaseAppRoutes, val img: Int, val text: Int) {

    object UsersBottomItem : BottomNavRoutes(BaseAppRoutes.UsersScreen, R.drawable.ic_users, R.string.users)
    object AddNewUserBottomItem : BottomNavRoutes(BaseAppRoutes.AddNewUserScreen, R.drawable.ic_add_user, R.string.sign_up)
}