package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.domain.NetworkEntity

data class UsersDto(
    @SerializedName("users")
    val users: List<UserDto>?
) : NetworkEntity
