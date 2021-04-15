package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.api.ThingsToDoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetDataModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesThingsToDoService(retrofit: Retrofit): ThingsToDoService {
        return retrofit.create(ThingsToDoService::class.java)
    }

}