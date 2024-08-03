package com.pfv.abzagencytesttask.data.remote.api

import com.pfv.abzagencytesttask.data.dto.CreateNewUserRequestDto
import com.pfv.abzagencytesttask.data.dto.CreatedUserDto
import com.pfv.abzagencytesttask.data.dto.Token
import com.pfv.abzagencytesttask.data.dto.UsersDto
import com.pfv.abzagencytesttask.data.remote.network.NetworkResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TestTaskService {

    @GET(USERS)
    suspend fun getAllUsers() : NetworkResult<UsersDto>

    @GET(TOKEN)
    suspend fun getUserCreationToken() : NetworkResult<Token>

    @POST(USERS)
    suspend fun createNewUser(
        @Header("Token") token: String,
        @Body user: CreateNewUserRequestDto
    ) : NetworkResult<CreatedUserDto>

    companion object {

        const val USERS = "users/"
        const val TOKEN = "token"
    }
}