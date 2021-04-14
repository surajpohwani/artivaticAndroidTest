package com.surajpohwani.surajpohwaniartivaticandroidtest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.Row
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel

@Database(entities = [Row::class, ThingsToDoModel::class], version = 1, exportSchema = false)
abstract class ThingsToDoDatabase : RoomDatabase() {

    abstract fun rowDao(): ThingsToDoRowDao
    abstract fun thingsToDoModel(): ThingsToDoCountryDao

}