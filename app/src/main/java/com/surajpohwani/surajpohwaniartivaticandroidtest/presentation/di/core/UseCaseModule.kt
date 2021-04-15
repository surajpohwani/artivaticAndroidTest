package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.core

import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.repository.GetThingsToDoRepository
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.GetThingsToDoListUseCase
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.UpdateTingsToDoUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetThingsToDoListUseCase(repository: GetThingsToDoRepository): GetThingsToDoListUseCase {
        return GetThingsToDoListUseCase(repository)
    }

    @Provides
    fun providesUpdateThingsToDoListUseCase(repository: GetThingsToDoRepository): UpdateTingsToDoUseCase {
        return UpdateTingsToDoUseCase(repository)
    }

}