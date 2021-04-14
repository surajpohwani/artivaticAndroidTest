package com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel

interface ThingsToDoLocalDataSource {

    suspend fun getThingsToDoListFromDb(id:String): ThingsToDoModel?
    suspend fun saveThingsToDoListToDb(thingsToDoList: ThingsToDoModel)
    suspend fun clearAll(id:String)

}