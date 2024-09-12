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
                val id = SessionController.getId(context)
                val details = UserAPIService.callable.updateUserInfo(id,details)

                Log.d("update", "${details.id}")
            } catch (e: Exception) {

                Log.e("error", e.toString())
            }
        }
    }
}