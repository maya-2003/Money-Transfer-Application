package com.teamj.moneytransferapp.data

import android.content.Context

object UserPrefs {

        fun finishOnboarding(context: Context): Boolean {
            val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val state = editor.getBoolean("show_onboarding", false)
            return state
        }

        fun setUserOnboarding(context: Context) {
            val editor= context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
            editor.putBoolean("show_onboarding", true)
            editor.apply()
        }

}