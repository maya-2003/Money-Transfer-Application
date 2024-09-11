package com.teamj.moneytransferapp.api.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.UserLogin
import kotlinx.coroutines.launch

class UserLoginViewModel: ViewModel() {
    fun loginUser(context: Context, email: String, password: String, storePrefs: (String, Int) -> Unit) {
        val loginRequest = UserLogin(email, password)

        viewModelScope.launch {
            try {
                val response = UserAPIService.callable.loginUser(loginRequest)
                Log.d("LoginSuccess", "Token: ${response.token} ID: ${response.id}")
                storePrefs(response.token, response.id)

            } catch (e: Exception) {
                Log.e("LoginError", e.toString())
            }
        }
    }
}