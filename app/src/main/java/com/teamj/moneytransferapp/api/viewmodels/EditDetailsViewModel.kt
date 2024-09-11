package com.teamj.moneytransferapp.api.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.UpdatedDetails
import kotlinx.coroutines.launch

class EditDetailsViewModel : ViewModel() {
    fun updateDetails(context : Context,details: UpdatedDetails) {
        viewModelScope.launch {
            try {
                val userId = SessionController.getUserId(context)
                val response = UserAPIService.callable.updateUserInfo(userId,details)

                Log.d("RegisterSuccess", "User registered with ID: ${response.id}")
            } catch (e: Exception) {

                Log.e("RegisterError", e.toString())
            }
        }
    }
}