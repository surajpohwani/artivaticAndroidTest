package com.surajpohwani.surajpohwaniartivaticandroidtest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "things_row")
data class Row(

    @Expose(serialize = false)
    val parentId: String,

    @Expose(serialize = false)
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val description: String,
    val imageHref: String,
    val title: String
)