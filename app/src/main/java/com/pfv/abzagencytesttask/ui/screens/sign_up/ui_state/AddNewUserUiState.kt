package com.pfv.abzagencytesttask.ui.screens.sign_up.ui_state

sealed class AddNewUserUiState {

    object InitState : AddNewUserUiState()
    object PickImageBottomSheet : AddNewUserUiState()
}