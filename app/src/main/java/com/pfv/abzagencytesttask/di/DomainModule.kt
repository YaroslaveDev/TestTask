package com.pfv.abzagencytesttask.di

import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository
import com.pfv.abzagencytesttask.domain.use_case.GetAllUsersUseCase
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
}