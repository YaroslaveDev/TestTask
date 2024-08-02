package com.pfv.abzagencytesttask.ui.screens.users.screen_state

sealed class UsersScreenState {

    object SetupState : UsersScreenState()
    object EmptyState : UsersScreenState()
    object SuccessState : UsersScreenState()
}