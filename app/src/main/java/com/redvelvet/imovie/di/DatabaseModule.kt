package com.redvelvet.imovie.di

import android.content.Context
import androidx.room.Room
import com.redvelvet.local.room.MovieDao
import com.redvelvet.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "movies_database"

    @Singleton
    @Provides
    fun provideMovieDatabase(
        @ApplicationContext context: Context
    ): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.getMovieDao()

}