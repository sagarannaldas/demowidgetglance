package com.sagarannaldas.demowidgetglance.db.repository

import com.sagarannaldas.demowidgetglance.db.dao.NotesDao
import com.sagarannaldas.demowidgetglance.db.model.Note
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepository @Inject constructor(
    private val notesDao: NotesDao,
    private val glanceWidgetRepository: GlanceWidgetRepository
) {
    suspend fun addRandomNote() {
        val uuid = UUID.randomUUID().toString()
        val randomNote = Note(
            title = uuid
        )
        notesDao.insertNote(randomNote)
        glanceWidgetRepository.noteInserted()
    }
    fun getNotes() = notesDao.getNotes()
    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
        glanceWidgetRepository.noteDeleted()
    }
}