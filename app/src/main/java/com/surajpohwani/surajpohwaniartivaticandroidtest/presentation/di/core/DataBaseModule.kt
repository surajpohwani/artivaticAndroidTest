package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoCountryDao
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoDatabase
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoRowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesThingsToDoDatabase(context: Context): ThingsToDoDatabase {
        return Room.databaseBuilder(context, ThingsToDoDatabase::class.java, "ThingsToDoDatabase")
            .build()

    }

    @Singleton
    @Provides
    fun providesThingsToDoCountryDao(thingsToDoDatabase: ThingsToDoDatabase): ThingsToDoCountryDao {
        return thingsToDoDatabase.thingsToDoModel()
    }

    @Singleton
    @Provides
    fun providesThingsToDoRowDao(thingsToDoDatabase: ThingsToDoDatabase): ThingsToDoRowDao {
        return thingsToDoDatabase.rowDao()
    }

}