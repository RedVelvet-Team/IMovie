package com.redvelvet.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.redvelvet.local.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}