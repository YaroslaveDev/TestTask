package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.domain.NetworkEntity

data class UserDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("position")
    val position: String?
)