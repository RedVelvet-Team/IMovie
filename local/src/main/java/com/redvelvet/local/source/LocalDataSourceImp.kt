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

    override suspend fun setToken(token: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.Token] = token
        }

    }

    override fun getToken(): String? {
        return runBlocking {
            dataStore.data.first()[PreferencesKeys.Token]
        }
    }

    override suspend fun setSessionId(id: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SessionId] = id
        }
    }

    override fun getSessionId(): String? {
        return runBlocking { dataStore.data.first()[PreferencesKeys.SessionId] }
    }

    override suspend fun setGuestSessionId(id: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.GuestSessionId] = id
        }
    }

    override fun getGuestSessionId(): String? {
        return runBlocking {
            dataStore.data.first()[PreferencesKeys.GuestSessionId]
        }
    }

    override suspend fun setGuestSessionExpDate(expiresAt: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.GuestSessionExpDate] = expiresAt
        }
    }

    override fun getGuestSessionExpDate(): String? {
        return runBlocking {
            dataStore.data.first()[PreferencesKeys.GuestSessionExpDate]
        }
    }

    //endregion


}