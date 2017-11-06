package com.laquysoft.cleanchucknorrisator

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by joaobiriba on 06/11/2017.
 */
class Prefs(context: Context) {
    val PREFS_JOKES = "com.laquysoft.cleanchucknorrisator.prefs"
    val PREFS_NO_EXPLICIT = "NO_EXPLICIT"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_JOKES, 0);

    var noExplicit: Boolean
        get() = prefs.getBoolean(PREFS_NO_EXPLICIT, false)
        set(value) = prefs.edit().putBoolean(PREFS_NO_EXPLICIT, value).apply()
}
