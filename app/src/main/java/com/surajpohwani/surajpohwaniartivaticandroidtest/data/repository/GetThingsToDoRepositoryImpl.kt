package com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.Row
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel
import com.surajpohwani.surajpohwaniartivaticandroidtest.domain.repository.GetThingsToDoRepository
import java.lang.Exception

class GetThingsToDoRepositoryImpl(
    private val thingsToDoLocalDataSource: ThingsToDoLocalDataSource,
    private val thingsToDoRemoteDataSource: ThingsToDoRemoteDataSource
) : GetThingsToDoRepository {
    override suspend fun getThingsToDoList(id: String): ThingsToDoModel {
        return getThingsToDoFromDb(id)
    }

    override suspend fun updateThingsToDoList(id: String): ThingsToDoModel {
        val newThingsToDoModel = getThingsToDoFromAPi(id)
        thingsToDoLocalDataSource.clearAll(id)
        thingsToDoLocalDataSource.saveThingsToDoListToDb(newThingsToDoModel)
        return newThingsToDoModel
    }

    suspend fun getThingsToDoFromAPi(id: String): ThingsToDoModel {
        lateinit var thingsToDoModel: ThingsToDoModel
        try {
            val response = thingsToDoRemoteDataSource.getThingsToDoRemote(id)
            val body = response?.body()
            if (body != null) {
                thingsToDoModel = body
            }
        } catch (e: Exception) {

        }
        return thingsToDoModel
    }

    suspend fun getThingsToDoFromDb(id: String): ThingsToDoModel {
        lateinit var thingsToDoModel: ThingsToDoModel
        try {
            val data = thingsToDoLocalDataSource.getThingsToDoListFromDb(id)
            if (data != null)
                return data
            else {
                thingsToDoModel = getThingsToDoFromAPi(id)
                thingsToDoModel.id = id
                for (row:Row in thingsToDoModel.rows)
                    row.parentId = id
                thingsToDoLocalDataSource.saveThingsToDoListToDb(thingsToDoModel)
            }

        } catch (e: Exception) {
            e.printStackTrace()

        }
        return thingsToDoModel
    }
}