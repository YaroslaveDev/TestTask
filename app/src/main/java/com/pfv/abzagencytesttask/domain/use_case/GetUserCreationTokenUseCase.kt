package com.pfv.abzagencytesttask.domain.use_case

import com.pfv.abzagencytesttask.domain.NetworkEntity
import com.pfv.abzagencytesttask.domain.ResultState
import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository

class GetUserCreationTokenUseCase(private val testTaskRepository: TestTaskRepository) {

    suspend operator fun invoke() : ResultState<NetworkEntity> {
        return testTaskRepository.getUserCreationToken()
    }
}