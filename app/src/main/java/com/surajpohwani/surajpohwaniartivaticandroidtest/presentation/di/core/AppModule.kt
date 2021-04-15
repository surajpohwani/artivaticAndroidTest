package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import android.content.Context
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.MainActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MainActivitySubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return context.applicationContext
    }

}