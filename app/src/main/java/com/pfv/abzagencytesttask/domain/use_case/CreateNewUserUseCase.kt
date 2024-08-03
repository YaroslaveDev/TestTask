package com.pfv.abzagencytesttask.domain.use_case

import com.pfv.abzagencytesttask.domain.NetworkEntity
import com.pfv.abzagencytesttask.domain.ResultState
import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository


class CreateNewUserUseCase(private val testTaskRepository: TestTaskRepository) {

    suspend operator fun invoke(token: String, user: NetworkEntity) : ResultState<NetworkEntity> {
        return testTaskRepository.createNewUser(token, user)
    }
}