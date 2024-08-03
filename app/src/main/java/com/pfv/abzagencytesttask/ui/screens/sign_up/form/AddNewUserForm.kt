package com.pfv.abzagencytesttask.ui.screens.sign_up.form

import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.ext.isNotNull
import com.pfv.abzagencytesttask.ext.isNull

data class AddNewUserForm(

    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val position: ITPosition = ITPosition.FRONTEND,

    val nameError: Int? = null,
    val emailError: Int? = null,
    val phoneError: Int? = null,
){

    fun isAllFieldsValid() =
        nameError.isNotNull() &&
        emailError.isNotNull() &&
        phoneError.isNotNull()
}