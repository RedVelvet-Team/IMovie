package com.redvelvet.local.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}