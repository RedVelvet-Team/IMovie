package com.redvelvet.local.util

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKeys {
    val IsLoggedByAccount = booleanPreferencesKey("is_logged_by_account")
    val IsLoggedByGuest = booleanPreferencesKey("is_logged_by_guest")
    val IsFirstTimeUsingApp = booleanPreferencesKey("is_first_time_using_app")
}