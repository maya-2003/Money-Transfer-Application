package com.teamj.moneytransferapp.api.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.User
import kotlinx.coroutines.launch

class UserRegisterViewModel : ViewModel() {
    fun registerUser(user: User) {
        viewModelScope.launch {
            try {
                val registerResp = UserAPIService.callable.registerUser(user)

                Log.d("register", "registered ${registerResp.id}")
            } catch (e: Exception) {

                Log.e("error", e.toString())
            }
        }
    }
}