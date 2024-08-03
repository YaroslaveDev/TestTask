package com.pfv.abzagencytesttask.data.dvo

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.domain.NetworkEntity

data class CreatedUserDvo(
    val success: Boolean,
    val userId: String? = null,
    val message: String,
) : NetworkEntity
