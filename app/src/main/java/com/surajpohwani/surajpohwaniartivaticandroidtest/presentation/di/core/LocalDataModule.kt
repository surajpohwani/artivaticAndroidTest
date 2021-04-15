package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoCountryDao
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoRowDao
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.ThingsToDoLocalDataSource
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository.ThingsToDoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesThingsToDoLocalDataSource(
        thingsToDoCountryDao: ThingsToDoCountryDao,
        thingsToDoRowDao: ThingsToDoRowDao
    ):ThingsToDoLocalDataSource{
        return ThingsToDoLocalDataSourceImpl(thingsToDoCountryDao, thingsToDoRowDao)
    }



}