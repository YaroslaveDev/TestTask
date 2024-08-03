package com.pfv.abzagencytesttask.data.repository

import com.pfv.abzagencytesttask.data.dto.CreateNewUserRequestDto
import com.pfv.abzagencytesttask.data.dto.Token
import com.pfv.abzagencytesttask.data.mapper.UsersDataDtoToDvoMapper
import com.pfv.abzagencytesttask.data.remote.api.TestTaskService
import com.pfv.abzagencytesttask.data.remote.network.toResultState
import com.pfv.abzagencytesttask.domain.NetworkEntity
import com.pfv.abzagencytesttask.domain.ResultState
import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository
import javax.inject.Inject

class TestTaskRepositoryImpl @Inject constructor(
    val testTaskService: TestTaskService
) : TestTaskRepository {

    override suspend fun getAllUsers(): ResultState<NetworkEntity> {
        return testTaskService.getAllUsers().toResultState { UsersDataDtoToDvoMapper(it).transform() }
    }

    override suspend fun createNewUser(
        token: String,
        user: NetworkEntity
    ): ResultState<NetworkEntity> {
        return testTaskService.createNewUser(token, user as CreateNewUserRequestDto).toResultState { it }
    }

    override suspend fun getUserCreationToken(): ResultState<Token> {
        return testTaskService.getUserCreationToken().toResultState { it }
    }

}