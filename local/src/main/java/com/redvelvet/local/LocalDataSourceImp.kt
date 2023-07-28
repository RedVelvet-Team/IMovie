package com.redvelvet.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.redvelvet.local.room.MovieDao
import com.redvelvet.repository.LocalDataSource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val movieDao: MovieDao,
) : LocalDataSource {

    // region user
    override suspend fun setIsLoggedByAccount(isLogged: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IsLoggedByAccount] = isLogged
        }
    }

    override suspend fun getIsLoggedByAccount(): Boolean {
        return dataStore.data.first()[PreferencesKeys.IsLoggedByAccount] ?: false
    }

    override suspend fun setIsLoggedByGuest(isLogged: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IsLoggedByGuest] = isLogged
        }
    }

    override suspend fun getIsLoggedByGuest(): Boolean {
        return dataStore.data.first()[PreferencesKeys.IsLoggedByGuest] ?: false
    }

    override suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IsFirstTimeUsingApp] = isFirstTime
        }
    }

    override suspend fun getIsFirstTimeUsingApp(): Boolean {
        return dataStore.data.first()[PreferencesKeys.IsFirstTimeUsingApp] ?: true
    }
    //endregion


    private  object PreferencesKeys {
        val IsLoggedByAccount   = booleanPreferencesKey("is_logged_by_account")
        val IsLoggedByGuest     = booleanPreferencesKey("is_logged_by_guest")
        val IsFirstTimeUsingApp = booleanPreferencesKey("is_first_time_using_app")
    }

}