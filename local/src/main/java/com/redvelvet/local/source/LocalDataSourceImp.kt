package com.redvelvet.local.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.redvelvet.local.util.PreferencesKeys
import com.redvelvet.repository.source.LocalDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val dataStore: DataStore<Preferences>,
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

    override suspend fun setToken(value: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.Token] = value
        }

    }

    override fun getToken(): String? {
        return runBlocking {
            dataStore.data.first()[PreferencesKeys.Token]
        }
    }

    override suspend fun setSessionId(value: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SessionId] = value
        }
    }

    override fun getSessionId(): String? {
        return runBlocking { dataStore.data.first()[PreferencesKeys.SessionId] }
    }

    //endregion


}