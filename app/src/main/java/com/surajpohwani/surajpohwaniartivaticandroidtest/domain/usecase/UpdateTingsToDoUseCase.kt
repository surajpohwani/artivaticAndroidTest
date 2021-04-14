package com.surajpohwani.surajpohwaniartivaticandroidtest.domain.usecase

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.repository.GetThingsToDoRepository

class UpdateTingsToDoUseCase(private val getThingsToDoRepository: GetThingsToDoRepository) {
    suspend fun execute(id: String): ThingsToDoModel =
        getThingsToDoRepository.updateThingsToDoList(id)
}