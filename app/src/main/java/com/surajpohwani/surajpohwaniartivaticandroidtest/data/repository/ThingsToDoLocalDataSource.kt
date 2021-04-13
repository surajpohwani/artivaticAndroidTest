package com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel

interface ThingsToDoLocalDataSource {

    suspend fun getThingsToDoListFromDb(): List<ThingsToDoModel>
    suspend fun saveThingsToDoListToDb(thingsToDoList: List<ThingsToDoModel>)
    suspend fun clearAll()

}