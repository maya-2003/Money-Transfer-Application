package com.teamj.moneytransferapp.api

import android.content.Context

object SessionController {

    fun getId(context: Context): Int {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        return editor.getInt("user_id", -1)
    }


    fun getToken(context: Context): String? {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        return editor.getString("auth_token", "")
    }

    fun clearSession(context: Context) {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
        editor.remove("auth_token")
        editor.remove("user_id")
        editor.apply()
    }

}