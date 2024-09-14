package com.teamj.moneytransferapp.api.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.UserLogin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserLoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.WaitingLogin)
    val loginState = _loginState.asStateFlow()

    fun loginUser(context: Context, email: String, password: String, storePrefs: (String, Int) -> Unit) {
        val loginRequest = UserLogin(email, password)

        viewModelScope.launch {
            try {
                _loginState.value = LoginState.LoggingIn

                val loginResp = UserAPIService.callable.loginUser(loginRequest)
                storePrefs(loginResp.token, loginResp.id)

                _loginState.value = LoginState.LoggedIn

            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "error")
                Log.e("LoginError", e.toString())
            }
        }
    }
}


sealed class LoginState {
    object WaitingLogin : LoginState()
    object LoggingIn : LoginState()
    object LoggedIn : LoginState()
    data class Error(val message: String) : LoginState()
}