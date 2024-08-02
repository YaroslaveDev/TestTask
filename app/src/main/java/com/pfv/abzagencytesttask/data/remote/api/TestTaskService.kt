package com.pfv.abzagencytesttask.data.remote.api

import com.pfv.abzagencytesttask.data.dto.UsersDto
import com.pfv.abzagencytesttask.data.remote.network.NetworkResult
import retrofit2.http.GET

interface TestTaskService {

    @GET(GET_ALL_USERS_ENDPOINT)
    suspend fun getAllUsers() : NetworkResult<UsersDto>

    companion object {

        const val GET_ALL_USERS_ENDPOINT = "users/"
    }
}