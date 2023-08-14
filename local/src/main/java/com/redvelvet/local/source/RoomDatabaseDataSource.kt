package com.redvelvet.local.source

import com.redvelvet.local.room.MovieDao
import com.redvelvet.repository.source.LocalDataSource
import javax.inject.Inject

class RoomDatabaseDataSource @Inject constructor(
    private val dao: MovieDao,
) : LocalDataSource {
}