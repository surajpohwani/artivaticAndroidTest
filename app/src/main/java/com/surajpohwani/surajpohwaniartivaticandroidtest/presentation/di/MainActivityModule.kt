package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di

import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.GetThingsToDoListUseCase
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.UpdateTingsToDoUseCase
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @MainActivityScope
    @Provides
    fun provideMainViewModelFactory(
        getThingsToDoListUseCase: GetThingsToDoListUseCase,
        updateTingsToDoUseCase: UpdateTingsToDoUseCase
    ):MainViewModelFactory{
        return MainViewModelFactory(getThingsToDoListUseCase, updateTingsToDoUseCase)
    }

}