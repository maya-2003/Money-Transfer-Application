package com.teamj.moneytransferapp.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {
    private val _splashShow = MutableStateFlow(true)
    val splashShow = _splashShow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _splashShow.value = false
        }
    }
}