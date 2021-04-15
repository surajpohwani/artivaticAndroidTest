package com.surajpohwani.surajpohwaniartivaticandroidtest

import android.app.Application
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.Injector
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.MainActivitySubComponent
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core.AppComponent
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core.AppModule
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core.DaggerAppComponent
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core.NetDataModule
import dagger.Component

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netDataModule(NetDataModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun createMainActivitySubComponent(): MainActivitySubComponent {
        return appComponent.mainActivitySubComponent().create()
    }
}