package com.teamj.moneytransferapp.api

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object SessionController {

    fun getUserId(context: Context): Int {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        return editor.getInt("user_id", -1)
    }

    fun getToken(context: Context): String? {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        return editor.getString("auth_token", null)
    }

    fun clearSession(context: Context) {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }

}