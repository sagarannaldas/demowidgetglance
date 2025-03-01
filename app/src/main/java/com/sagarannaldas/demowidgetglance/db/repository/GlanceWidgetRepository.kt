package com.sagarannaldas.demowidgetglance.db.repository

import android.content.Context
import androidx.glance.appwidget.updateAll
import com.sagarannaldas.demowidgetglance.db.dao.NotesDao
import com.sagarannaldas.demowidgetglance.db.model.Note
import com.sagarannaldas.demowidgetglance.widget.MyAppWidget
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class GlanceWidgetRepository @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val notesDao: NotesDao
) {
    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface GlanceTutorialWidgetRepositoryEntryPoint {
        fun widgetRepository(): GlanceWidgetRepository
    }

    companion object {
        fun get(applicationContext: Context): GlanceWidgetRepository {
            val widgetModelRepositoryEntryPoint: GlanceTutorialWidgetRepositoryEntryPoint =
                EntryPoints.get(
                    applicationContext,
                    GlanceTutorialWidgetRepositoryEntryPoint::class.java,
                )
            return widgetModelRepositoryEntryPoint.widgetRepository()
        }
    }

    suspend fun noteInserted() {
        MyAppWidget().updateAll(appContext)
    }

    suspend fun noteDeleted() {
        MyAppWidget().updateAll(appContext)
    }

    fun loadNotes(): Flow<List<Note>> {
        return notesDao.getNotes().distinctUntilChanged()
    }
}