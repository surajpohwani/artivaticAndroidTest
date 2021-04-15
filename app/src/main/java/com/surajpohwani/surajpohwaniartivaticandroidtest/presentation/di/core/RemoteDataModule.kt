package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.api.ThingsToDoService
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.ThingsToDoRemoteDataSource
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.ThingsToDoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesThingsToDoRemoteDataSource(thingsToDoService: ThingsToDoService):ThingsToDoRemoteDataSource{
        return ThingsToDoRemoteDataSourceImpl(thingsToDoService)
    }


}