package com.pfv.abzagencytesttask.ui.screens.sign_up.ui_state

sealed class AddNewUserUiState {

    object InitState : AddNewUserUiState()
    object PickImageBottomSheet : AddNewUserUiState()
    object UserSuccessCreated : AddNewUserUiState()
    data class Error(val text: String) : AddNewUserUiState()
    object Setup : AddNewUserUiState()
}