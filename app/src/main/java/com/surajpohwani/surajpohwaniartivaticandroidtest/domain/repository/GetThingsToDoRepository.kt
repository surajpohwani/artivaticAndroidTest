package com.surajpohwani.surajpohwaniartivaticandroidtest.domain.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel

interface GetThingsToDoRepository {

    suspend fun getThingsToDoList(): List<ThingsToDoModel>
    suspend fun updateThingsToDoList(): List<ThingsToDoModel>

}