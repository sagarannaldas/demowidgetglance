package com.sagarannaldas.demowidgetglance.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sagarannaldas.demowidgetglance.db.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>
    @Insert
    fun insertNote(note: Note)
    @Delete
    fun deleteNote(note: Note)
}