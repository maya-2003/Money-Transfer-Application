package com.teamj.moneytransferapp.api.viewmodels

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.Transfer
import com.teamj.moneytransferapp.api.model.TransferResp
import com.teamj.moneytransferapp.corefun.ErrorAlertDialog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class TransferViewModel : ViewModel() {
    private val _transferInfo = MutableStateFlow<TransferResp?>(null)
    val transferInfo = _transferInfo.asStateFlow()
    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()
    private val _messageError = MutableStateFlow("")


    fun transferMoney(transferDetails: Transfer) {
        viewModelScope.launch {
            try {
                val response = UserAPIService.callable.transfer(transferDetails)
                _transferInfo.value = response
                _hasError.value = false

                Log.d("TransferSuccess", "User registered with ID: ${response.amount}")
            } catch (e: HttpException) {
                Log.e("TransferError", e.toString())
                _hasError.value = true
                _messageError.value = MutableStateFlow("${e.toString()}").toString()

            }
        }
    }
}