package com.pfv.abzagencytesttask.di

import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository
import com.pfv.abzagencytesttask.domain.use_case.CreateNewUserUseCase
import com.pfv.abzagencytesttask.domain.use_case.GetAllUsersUseCase
import com.pfv.abzagencytesttask.domain.use_case.GetUserCreationTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetAllUsersUseCase(repository: TestTaskRepository) =
        GetAllUsersUseCase(testTaskRepository = repository)

    @Provides
    fun provideGetUserCreationTokenUseCase(repository: TestTaskRepository) =
        GetUserCreationTokenUseCase(testTaskRepository = repository)

    @Provides
    fun provideCreateNewUserUseCase(repository: TestTaskRepository) =
        CreateNewUserUseCase(testTaskRepository = repository)
}