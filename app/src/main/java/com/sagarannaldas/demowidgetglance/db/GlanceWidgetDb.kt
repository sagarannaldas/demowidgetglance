package com.sagarannaldas.demowidgetglance.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sagarannaldas.demowidgetglance.db.dao.NotesDao
import com.sagarannaldas.demowidgetglance.db.model.Note

@Database(entities = [Note::class], version = 1)
abstract class GlanceWidgetDb : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}