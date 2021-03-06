package com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel
import retrofit2.Response

interface ThingsToDoRemoteDataSource {
    suspend fun getThingsToDoRemote(id:String): Response<ThingsToDoModel>?
}