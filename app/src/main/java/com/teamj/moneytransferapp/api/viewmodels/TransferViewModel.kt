package com.teamj.moneytransferapp.api.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.Transfer
import com.teamj.moneytransferapp.api.model.TransferResp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TransferViewModel : ViewModel() {
    private val _transferInfo = MutableStateFlow<TransferResp?>(null)
    val transferInfo = _transferInfo.asStateFlow()
    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()
    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()
    private val _transferSuccess = MutableStateFlow(false)
    val transferSuccess = _transferSuccess.asStateFlow()

    fun transferMoney(transferDetails: Transfer) {
        viewModelScope.launch {
            try {
                val response = UserAPIService.callable.transfer(transferDetails)
                _transferInfo.value = response
                _hasError.value = false
                _transferSuccess.value = true
            } catch (e: Exception) {
                _hasError.value = true
                _errorMessage.value = e.message.toString()
                _transferSuccess.value = false
            }
        }
    }
}