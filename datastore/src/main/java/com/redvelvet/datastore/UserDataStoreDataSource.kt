package com.redvelvet.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.redvelvet.datastore.util.PreferencesKeys
import com.redvelvet.datastore.util.get
import com.redvelvet.repository.source.UserPreferencesDataSource
import javax.inject.Inject

class UserDataStoreDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : UserPreferencesDataSource {
    // region user
    override suspend fun setIsLoggedInByAccount(isLogged: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IsLoggedByAccount] = isLogged
        }
    }

    override suspend fun getIsLoggedInByAccount(): Boolean {
        return dataStore.get()[PreferencesKeys.IsLoggedByAccount] ?: false
    }

    override suspend fun setIsLoggedInByGuest(isLogged: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IsLoggedByGuest] = isLogged
        }
    }

    override suspend fun getIsLoggedInByGuest(): Boolean {
        return dataStore.get()[PreferencesKeys.IsLoggedByGuest] ?: false
    }
    //endregion

    // region auth
    override suspend fun setUserSessionId(id: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SessionId] = id
        }
    }

    override suspend fun getUserSessionId(): String? {
        return dataStore.get()[PreferencesKeys.SessionId]
    }

    override suspend fun setGuestSession(id: String, expDate: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.GuestSessionId] = id
            preferences[PreferencesKeys.GuestSessionExpDate] = expDate
        }
    }

    override suspend fun getGuestSessionId(): String? {
        return dataStore.get()[PreferencesKeys.GuestSessionId]
    }

    override suspend fun getGuestSessionExpDate(): String? {
        return dataStore.get()[PreferencesKeys.GuestSessionExpDate]
    }

    override suspend fun getUserName(): String? {
        return dataStore.get()[PreferencesKeys.UserName]
    }

    override suspend fun setUserName(userName: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.UserName] = userName
        }
    }

    override suspend fun setAccountId(accountId: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.AccountDetailsId] = accountId.toString()
        }
    }

    override suspend fun setAccountUsername(accountUsername: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.AccountDetailsUsername] = accountUsername
        }
    }

    override suspend fun getAccountIdFromLocal(): Int? {
        return dataStore.get()[PreferencesKeys.AccountDetailsId]?.toInt()
    }

    override suspend fun getAccountUsernameFromLocal(): String? {
        return dataStore.get()[PreferencesKeys.AccountDetailsUsername]
    }
    //endregion
}