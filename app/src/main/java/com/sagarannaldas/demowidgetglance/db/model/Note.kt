package com.sagarannaldas.demowidgetglance.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "text") val text: String? = null
)