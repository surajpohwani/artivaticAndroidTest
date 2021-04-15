package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.MainActivitySubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        LocalDataModule::class,
        NetDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun mainActivitySubComponent(): MainActivitySubComponent.Factory
}