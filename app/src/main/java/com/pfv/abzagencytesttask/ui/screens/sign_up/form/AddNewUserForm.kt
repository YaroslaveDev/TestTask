package com.pfv.abzagencytesttask.ui.screens.sign_up.form

import android.net.Uri
import com.pfv.abzagencytesttask.data.constants.ITPosition
import com.pfv.abzagencytesttask.data.dvo.PositionDvo
import com.pfv.abzagencytesttask.ext.isNotNull
import com.pfv.abzagencytesttask.ext.isNull

data class AddNewUserForm(

    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val position: PositionDvo = PositionDvo("", ""),
    val image: Uri? = null,
    val availablePositions: List<PositionDvo> = listOf(),

    val nameError: Int? = null,
    val emailError: Int? = null,
    val phoneError: Int? = null,
    val imageError: Int? = null
){

    fun getImageName() = image?.path  ?: ""

    fun isAllFieldsValid() =
        nameError.isNull() &&
        emailError.isNull() &&
        phoneError.isNull() &&
                imageError.isNull()
}