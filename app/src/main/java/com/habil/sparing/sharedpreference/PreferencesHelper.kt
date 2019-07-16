package com.habil.adoption.data

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.habil.adoption.data.PreferencesUtility.EMAIL
import com.habil.adoption.data.PreferencesUtility.FULL_NAME
import com.habil.adoption.data.PreferencesUtility.LOGIN
import com.habil.adoption.data.PreferencesUtility.STARTUP
import com.habil.adoption.data.PreferencesUtility.URL_PHOTO
import com.habil.adoption.data.PreferencesUtility.USER_NAME

class PreferencesHelper {
    internal fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    //save email user
    fun setEmailUser(context: Context, email: String) {
        val editor = getPreferences(context).edit()
        editor.putString(EMAIL, email)
        editor.apply()
    }

    fun getEmailUser(context: Context): String? {
        return getPreferences(context).getString(EMAIL, "")
    }

    //save login session
    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(LOGIN, loggedIn)
        editor.apply()
    }


    fun getLoggedStatus(context: Context): Boolean {
        return getPreferences(context).getBoolean(LOGIN, false)
    }

    //save login session
    fun setStartup(context: Context, startUp: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(STARTUP, startUp)
        editor.apply()
    }


    fun getStartup(context: Context): Boolean {
        return getPreferences(context).getBoolean(STARTUP, false)
    }

    fun reset(context: Context): Boolean {
        val editor = getPreferences(context).edit().clear().commit()
        return editor
    }


    //save fullname user
    fun setFullName(context: Context, fullName: String) {
        val editor = getPreferences(context).edit()
        editor.putString(FULL_NAME, fullName)
        editor.apply()
    }

    fun getFullName(context: Context): String? {
        return getPreferences(context).getString(FULL_NAME, "")
    }

    //photoprofile
    fun setPhoto(context: Context, url: String) {
        val editor = getPreferences(context).edit()
        editor.putString(URL_PHOTO, url)
        editor.apply()
    }

    fun getPhoto(context: Context): String? {
        return getPreferences(context).getString(URL_PHOTO,"")
    }

    //save name user
    fun setNameUser(context: Context, nameUser: String) {
        val editor = getPreferences(context).edit()
        editor.putString(USER_NAME, nameUser)
        editor.apply()

    }

    fun getNameUser(context: Context): String? {
        return getPreferences(context).getString(USER_NAME, "")
    }


}


