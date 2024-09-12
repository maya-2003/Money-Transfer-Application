package com.teamj.moneytransferapp.api.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.Password
import kotlinx.coroutines.launch

class PasswordViewModel : ViewModel(){
    fun changePassword(context : Context, password: Password) {

        viewModelScope.launch {
            try {
                val userId = SessionController.getId(context)
                val change = UserAPIService.callable.updateUserPassword(userId,password)

                if (change.isSuccessful) {
                    Log.d("password", "success")
                } else {
                    Log.e("password", "failed")
                }
            } catch (e: Exception) {

                Log.e("error", e.toString())
            }
        }
    }
}