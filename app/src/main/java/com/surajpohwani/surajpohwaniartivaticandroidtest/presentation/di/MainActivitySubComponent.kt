package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di

import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.MainActivity
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MainActivitySubComponent
    }
}