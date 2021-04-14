package com.surajpohwani.surajpohwaniartivaticandroidtest.domain.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel

interface GetThingsToDoRepository {

    suspend fun getThingsToDoList(id: String): ThingsToDoModel
    suspend fun updateThingsToDoList(id: String): ThingsToDoModel

}