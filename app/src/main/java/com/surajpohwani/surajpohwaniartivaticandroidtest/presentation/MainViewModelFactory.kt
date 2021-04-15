package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.GetThingsToDoListUseCase
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.UpdateTingsToDoUseCase

class MainViewModelFactory(
    private val getThingsToDoListUseCase: GetThingsToDoListUseCase,
    private val updateTingsToDoUseCase: UpdateTingsToDoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getThingsToDoListUseCase, updateTingsToDoUseCase) as T
    }
}