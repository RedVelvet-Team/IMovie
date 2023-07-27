package com.redvelvet.local.room

import androidx.room.Dao
import androidx.room.Insert
import com.redvelvet.local.localdto.MovieLocalDTO

@Dao
interface MovieDao {
    @Insert
    fun insertMovie(movieLocalDTO: MovieLocalDTO)
}