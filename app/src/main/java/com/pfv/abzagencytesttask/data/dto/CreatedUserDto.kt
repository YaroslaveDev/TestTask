package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.domain.NetworkEntity

data class CreatedUserDto(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("user_id")
    val userId: String?,
    @SerializedName("message")
    val message: String?,
) : NetworkEntity
