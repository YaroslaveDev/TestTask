package com.pfv.abzagencytesttask.ui.screens.users.nav_state

sealed class UsersScreenNavState {

    object InitState : UsersScreenNavState()
    data class NavToInfoPopup(val actionText: String, val text: String, val img: Int) : UsersScreenNavState()
}