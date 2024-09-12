package com.teamj.moneytransferapp.api.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TransactionsViewModel : ViewModel() {
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions = _transactions.asStateFlow()
    fun getTransactions(context: Context) {

        viewModelScope.launch {

            try {
                val id = SessionController.getId(context)

                val transactionResp = UserAPIService.callable.getTransactioHistory(id)
                _transactions.value = transactionResp

            } catch (e: Exception) {
                Log.e("error", e.toString())
                _transactions.value = emptyList()
            }
        }
    }

}