package com.pfv.abzagencytesttask.di

import android.app.Application
import com.pfv.abzagencytesttask.data.remote.api.TestTaskService
import com.pfv.abzagencytesttask.data.repository.TestTaskRepositoryImpl
import com.pfv.abzagencytesttask.domain.repository.TestTaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideTestTaskService(retrofit: Retrofit): TestTaskService =
        retrofit.create(TestTaskService::class.java)

    @Provides
    @Singleton
    fun provideTestTaskRepository(
        service: TestTaskService,
    ): TestTaskRepository =
        TestTaskRepositoryImpl(service)

}