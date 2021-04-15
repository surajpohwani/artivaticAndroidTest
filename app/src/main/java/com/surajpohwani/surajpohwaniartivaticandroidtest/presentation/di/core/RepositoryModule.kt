package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.GetThingsToDoRepositoryImpl
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.ThingsToDoLocalDataSource
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.ThingsToDoRemoteDataSource
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.repository.GetThingsToDoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesThingsToDoRepository(
        thingsToDoLocalDataSource: ThingsToDoLocalDataSource,
                                     thingsToDoRemoteDataSource: ThingsToDoRemoteDataSource
    ):GetThingsToDoRepository{
        return GetThingsToDoRepositoryImpl(thingsToDoLocalDataSource, thingsToDoRemoteDataSource)
    }
}