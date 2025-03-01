package com.sagarannaldas.demowidgetglance.di

import android.content.Context
import androidx.room.Room
import com.sagarannaldas.demowidgetglance.db.GlanceWidgetDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        GlanceWidgetDb::class.java,
        "glance_widget.db"
    ).build()

    @Provides
    fun providesNotesDao(database: GlanceWidgetDb) = database.notesDao()
}