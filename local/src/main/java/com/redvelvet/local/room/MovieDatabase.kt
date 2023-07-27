package com.redvelvet.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.redvelvet.local.localdto.MovieLocalDTO


@Database(entities = [MovieLocalDTO::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}