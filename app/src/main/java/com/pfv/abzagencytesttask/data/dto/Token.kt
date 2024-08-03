package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.domain.NetworkEntity

data class Token(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("token")
    val token: String?
) : NetworkEntity
