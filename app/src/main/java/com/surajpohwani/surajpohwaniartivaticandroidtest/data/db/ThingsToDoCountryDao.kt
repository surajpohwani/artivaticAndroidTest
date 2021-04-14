package com.surajpohwani.surajpohwaniartivaticandroidtest.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.ThingsToDoModel

@Dao
interface ThingsToDoCountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCountry(thingsToDoModel: ThingsToDoModel)

    @Query("DELETE FROM things_to_do_country")
    suspend fun deleteAllCountries()

    @Query("SELECT * FROM things_to_do_country WHERE id=:countryId")
    suspend fun getCountry(countryId: String): ThingsToDoModel

}
