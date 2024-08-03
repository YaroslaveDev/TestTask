package com.pfv.abzagencytesttask.ui.navigation.routes

import com.pfv.abzagencytesttask.R
import kotlinx.serialization.Serializable

sealed class BaseAppRoutes() {

    @Serializable
    object SplashScreen : BaseAppRoutes()

    @Serializable
    object UsersScreen : BaseAppRoutes()

    @Serializable
    object AddNewUserScreen : BaseAppRoutes()

    @Serializable
    object MainNavGraph : BaseAppRoutes()

    //Info Popups
    @Serializable
    data class BaseInfoPopup(val actionText: String, val text: String, val img: Int) : BaseAppRoutes()

}

sealed class BottomNavRoutes(val route: BaseAppRoutes, val img: Int, val text: Int) {

    object UsersBottomItem : BottomNavRoutes(BaseAppRoutes.UsersScreen, R.drawable.ic_users, R.string.users)
    object AddNewUserBottomItem : BottomNavRoutes(BaseAppRoutes.AddNewUserScreen, R.drawable.ic_add_user, R.string.sign_up)
}