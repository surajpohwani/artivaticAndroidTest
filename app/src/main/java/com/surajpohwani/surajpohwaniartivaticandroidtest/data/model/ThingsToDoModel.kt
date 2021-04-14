package com.surajpohwani.surajpohwaniartivaticandroidtest.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "things_to_do_country")
data class ThingsToDoModel(


    @PrimaryKey
    @Expose(serialize = false)
    val id: String,

    @Ignore
    val rows: List<Row>,

    val title: String
)