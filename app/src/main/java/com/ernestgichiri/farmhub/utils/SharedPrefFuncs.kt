package com.ernestgichiri.farmhub.utils

import android.content.SharedPreferences
import com.ernestgichiri.farmhub.common.Constants

fun getUserIdFromSharedPref(sharedPrefs: SharedPreferences): String {
    return sharedPrefs.getString(
        Constants.PREF_USERID_KEY,
        Constants.PREF_DEF_STR,
    ) ?: Constants.PREF_DEF_STR
}
