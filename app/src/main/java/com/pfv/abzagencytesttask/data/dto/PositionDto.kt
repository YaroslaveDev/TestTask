package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName

data class PositionDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)
