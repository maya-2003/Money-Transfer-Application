package com.maya.moneytransferapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {
    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactions: LiveData<List<Transaction>> = _transactions

    private val _balance = MutableLiveData<String>()
    val balance: LiveData<String> = _balance

    fun fetchData() {

        _transactions.value = listOf(
            Transaction("Ahmed Mohamed", "Visa", "1234", "Today 11:00", "500 EGP"),
        )
        _balance.value = "10000 EGP"
    }
}