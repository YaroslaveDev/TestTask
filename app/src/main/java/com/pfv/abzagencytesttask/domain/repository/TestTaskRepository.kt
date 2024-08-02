package com.pfv.abzagencytesttask.domain.repository

import com.pfv.abzagencytesttask.domain.NetworkEntity
import com.pfv.abzagencytesttask.domain.ResultState

interface TestTaskRepository {

    suspend fun getAllUsers() : ResultState<NetworkEntity>
    suspend fun createNewUser(user: NetworkEntity)
}