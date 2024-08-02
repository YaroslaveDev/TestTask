package com.pfv.abzagencytesttask.data.dvo

import com.google.gson.annotations.SerializedName

data class UserDvo(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val photo: String
)
