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
                val userId = SessionController.getUserId(context)
                val response = UserAPIService.callable.updateUserPassword(userId,password)

                if (response.isSuccessful) {
                    Log.d("ChangePassword", "Password successfully changed")
                } else {
                    Log.e("ChangePasswordError", "Failed to change password. Status code: ${response.code()}")
                }
            } catch (e: Exception) {

                Log.e("RegisterError", e.toString())
            }
        }
    }
}