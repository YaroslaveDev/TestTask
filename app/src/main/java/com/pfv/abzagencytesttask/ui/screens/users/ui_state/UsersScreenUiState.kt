package com.pfv.abzagencytesttask.ui.screens.users.ui_state

sealed class UsersScreenUiState {

    object NoInternetConnection : UsersScreenUiState()
    data class Error(val text: String) : UsersScreenUiState()
    object InitState : UsersScreenUiState()
}