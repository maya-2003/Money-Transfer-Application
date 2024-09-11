package com.teamj.moneytransferapp.api.model

data class TransferResp(
    val fromAccountId: Int,
    val toAccountId: Int,
    val fromAccountName: String,
    val toAccountName: String,
    val amount: Int,
    val transactionDate: String
)
