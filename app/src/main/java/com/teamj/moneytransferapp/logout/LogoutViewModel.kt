package com.teamj.moneytransferapp.logout

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LogoutViewModel : ViewModel() {
    fun logoutUser(context: Context, navController: NavController) {
        viewModelScope.launch {
            try {
                val token = SessionController.getToken(context)
                if (token != null) {
                    Log.d("LogoutFlow", "Found token, making logout API call")
                    val logoutResp = UserAPIService.callable.logout()
                    if (logoutResp.isSuccessful) {
                        Log.d("LogoutFlow", "Logout successful, clearing session")
                        SessionController.clearSession(context)
                        Log.d("logout", "success")

                        withContext(Dispatchers.Main) {
                            navController.navigate("login") {
                                popUpTo(0)
                            }
                        }
                    }

                    else {
                        Log.e("logout", "fail")
                    }
                }

                else {
                    Log.e("logout", "Token not found")
                }
            }

            catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
    }
}

