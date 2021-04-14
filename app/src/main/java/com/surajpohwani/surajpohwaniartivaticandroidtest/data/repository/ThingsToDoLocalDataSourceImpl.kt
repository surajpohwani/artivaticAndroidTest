package com.surajpohwani.surajpohwaniartivaticandroidtest.data.repository

import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoCountryDao
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.db.ThingsToDoRowDao
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ThingsToDoLocalDataSourceImpl(
    private val thingsToDoCountryDao: ThingsToDoCountryDao,
    private val thingsToDoRowDao: ThingsToDoRowDao
) : ThingsToDoLocalDataSource {
    override suspend fun getThingsToDoListFromDb(id: String): ThingsToDoModel? {
        val countryObject = CoroutineScope(Dispatchers.IO).async {
            thingsToDoCountryDao.getCountry(id)
        }.await()

        countryObject?.apply {
            rows = CoroutineScope(Dispatchers.IO).async {
                thingsToDoRowDao.getRows(id)
            }.await()
        }

        return countryObject
    }

    override suspend fun saveThingsToDoListToDb(thingsToDoList: ThingsToDoModel) {
        CoroutineScope(Dispatchers.IO).launch {
            thingsToDoCountryDao.saveCountry(thingsToDoList)
            thingsToDoRowDao.saveRows(thingsToDoList.rows)
        }

    }

    override suspend fun clearAll(id: String) {
        CoroutineScope(Dispatchers.IO).async {
            thingsToDoCountryDao.deleteAllCountries(id)
            thingsToDoRowDao.deleteAllRows(id)
        }.await()
    }
}