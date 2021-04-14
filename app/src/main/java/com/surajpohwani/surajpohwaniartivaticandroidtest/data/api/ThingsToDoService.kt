package com.surajpohwani.surajpohwaniartivaticandroidtest.data.api

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ThingsToDoService {

    //    @GET("c4ab4c1c-9a55-4174-9ed2-cbbe0738eedf")
    @GET("{id}")
    suspend fun getThingsToDoList(@Path("id") id: String): Response<ThingsToDoModel>

}