package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.domain.NetworkEntity
import okhttp3.MultipartBody
import retrofit2.http.Multipart

data class CreateNewUserRequestDto(

    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("position_id")
    val positionId: Int,
    @SerializedName("photo")
    val photo: MultipartBody.Part
) : NetworkEntity
