package com.teamj.moneytransferapp.api.model


data class TransactionRoot(val transactions: List<Transaction>)

data class Transaction(
    val fromAccountNumber: String,
    val toAccountNumber: String,
    val fromAccountName: String,
    val toAccountName: String,
    val amount: Int,
    val transactionDate: String
)
