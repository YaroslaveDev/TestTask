package com.pfv.abzagencytesttask.data.remote.api

import com.pfv.abzagencytesttask.data.dto.AvailablePositionsResponseDto
import com.pfv.abzagencytesttask.data.dto.CreateNewUserRequestDto
import com.pfv.abzagencytesttask.data.dto.CreatedUserDto
import com.pfv.abzagencytesttask.data.dto.Token
import com.pfv.abzagencytesttask.data.dto.UsersDto
import com.pfv.abzagencytesttask.data.remote.network.NetworkResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface TestTaskService {

    @GET(USERS)
    suspend fun getAllUsers() : NetworkResult<UsersDto>

    @GET(TOKEN)
    suspend fun getUserCreationToken() : NetworkResult<Token>

    @Multipart
    @POST(USERS)
    suspend fun createNewUser(
        @Header("Token") token: String,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("position_id") positionId: RequestBody,
        @Part photo: MultipartBody.Part
    ) : NetworkResult<CreatedUserDto>

    @GET(POSITIONS)
    suspend fun getAvailablePositions() : NetworkResult<AvailablePositionsResponseDto>

    companion object {

        const val USERS = "users/"
        const val TOKEN = "token"
        const val POSITIONS = "positions"
    }
}