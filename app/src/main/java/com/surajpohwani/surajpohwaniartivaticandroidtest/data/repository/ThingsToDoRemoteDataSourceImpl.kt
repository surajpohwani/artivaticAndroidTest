package com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.api.ThingsToDoService
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel
import retrofit2.Response

class ThingsToDoRemoteDataSourceImpl(
    private val thingsToDoService: ThingsToDoService
) : ThingsToDoRemoteDataSource {
    override suspend fun getThingsToDoRemote(id: String): Response<ThingsToDoModel>? =
        thingsToDoService.getThingsToDoList(id)

}