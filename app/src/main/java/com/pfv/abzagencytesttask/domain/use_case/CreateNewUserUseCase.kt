package com.pfv.abzagencytesttask.domain.use_case

import com.pfv.abzagencytesttask.domain.NetworkEntity
import com.pfv.abzagencytesttask.domain.ResultState
import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody


class CreateNewUserUseCase(private val testTaskRepository: TestTaskRepository) {

    suspend operator fun invoke(
        token: String,
        name: RequestBody,
        email: RequestBody,
        phone: RequestBody,
        positionId: RequestBody,
        photo: MultipartBody.Part
    ) : ResultState<NetworkEntity> {
        return testTaskRepository.createNewUser(
            token, name, email, phone, positionId, photo
        )
    }
}