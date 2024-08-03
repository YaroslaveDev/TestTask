package com.pfv.abzagencytesttask.domain.repository

import com.pfv.abzagencytesttask.data.dto.CreateNewUserRequestDto
import com.pfv.abzagencytesttask.data.dto.CreatedUserDto
import com.pfv.abzagencytesttask.data.dto.Token
import com.pfv.abzagencytesttask.data.remote.api.TestTaskService
import com.pfv.abzagencytesttask.data.remote.network.NetworkResult
import com.pfv.abzagencytesttask.domain.NetworkEntity
import com.pfv.abzagencytesttask.domain.ResultState
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TestTaskRepository {

    suspend fun getAllUsers() : ResultState<NetworkEntity>
    suspend fun createNewUser(token: String, user: NetworkEntity) : ResultState<NetworkEntity>
    suspend fun getUserCreationToken() : ResultState<Token>
}