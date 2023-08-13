package com.redvelvet.datastore.util

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val IsLoggedByAccount = booleanPreferencesKey("is_logged_by_account")
    val IsLoggedByGuest = booleanPreferencesKey("is_logged_by_guest")
    val SessionId = stringPreferencesKey("session_id")
    val GuestSessionId = stringPreferencesKey("guest_session_id")
    val GuestSessionExpDate = stringPreferencesKey("guest_exp_date_session")
}