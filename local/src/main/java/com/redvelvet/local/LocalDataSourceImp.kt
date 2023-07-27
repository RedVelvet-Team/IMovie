package com.redvelvet.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.redvelvet.local.room.MovieDao
import com.redvelvet.repository.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val movieDao: MovieDao
): LocalDataSource {

}