package com.pfv.abzagencytesttask.ui.screens.sign_up.event

import android.content.Context
import android.net.Uri
import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.ui.navigation.routes.BaseAppRoutes

sealed class AddNewUserEvent {

    data class UpdateName(val text: String) : AddNewUserEvent()
    data class UpdateEmail(val text: String) : AddNewUserEvent()
    data class UpdatePhone(val text: String) : AddNewUserEvent()
    data class UpdateITPosition(val position: ITPosition) : AddNewUserEvent()
    object ShowPickImageBottomSheet : AddNewUserEvent()
    data class OnSignUp(val context: Context) : AddNewUserEvent()
    data class OnImagePicked(val img: Uri) : AddNewUserEvent()
}