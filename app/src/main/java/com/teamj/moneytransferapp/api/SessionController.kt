package com.teamj.moneytransferapp.api

import android.content.Context

object SessionController {

    fun getId(context: Context): Int {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        return editor.getInt("user_id", -1)
    }


    fun clearSession(context: Context) {
        val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }

}