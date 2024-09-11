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
    fun transferMoney(transferDetails: Transfer) {
        viewModelScope.launch {
            try {
                val response = UserAPIService.callable.transfer(transferDetails)
                _transferInfo.value = response
                Log.d("TransferSuccess", "User registered with ID: ${response.amount}")
            } catch (e: Exception) {

                Log.e("TransferError", e.toString())
            }
        }
    }
}