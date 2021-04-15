package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.GetThingsToDoListUseCase
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase.UpdateTingsToDoUseCase

class MainViewModel(
    private val getThingsToDoListUseCase: GetThingsToDoListUseCase,
    private val updateTingsToDoUseCase: UpdateTingsToDoUseCase
) : ViewModel() {

    fun getThingsToDo(id: String) = liveData {
        val data = getThingsToDoListUseCase.execute(id)
        emit(data)
    }

    fun updateThingsToDo(id: String) = liveData {
        val data = updateTingsToDoUseCase.execute(id)
        emit(data)
    }

}