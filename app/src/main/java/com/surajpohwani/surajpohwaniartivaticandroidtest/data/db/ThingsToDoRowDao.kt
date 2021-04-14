package com.surajpohwani.surajpohwaniartivaticandroidtest.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.Row

@Dao
interface ThingsToDoRowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRows(rows: List<Row>)

    @Query("DELETE FROM things_row WHERE parentId=:countryId")
    suspend fun deleteAllRows(countryId: String)

    @Query("SELECT * FROM things_row WHERE parentId=:countryId")
    suspend fun getRows(countryId: String): List<Row>

}