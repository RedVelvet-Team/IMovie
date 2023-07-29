package com.redvelvet.local.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}