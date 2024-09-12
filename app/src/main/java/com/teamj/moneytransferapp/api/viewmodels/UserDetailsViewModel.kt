package com.teamj.moneytransferapp.api.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserDetailsViewModel : ViewModel() {
    private val _userDetails = MutableStateFlow<UserData?>(null)
    val userDetails = _userDetails.asStateFlow()

    fun getUserDetails(context: Context) {

        viewModelScope.launch {

            try {
                val userId = SessionController.getId(context)

                if (userId != -1) {
                    val details = UserAPIService.callable.getCustomerById(userId)
                    _userDetails.value = details
                } else {
                    Log.e("error", "id not found")
                }
            } catch (e: Exception) {
                Log.e("error", e.toString())
                _userDetails.value = null
            }
        }
    }
}