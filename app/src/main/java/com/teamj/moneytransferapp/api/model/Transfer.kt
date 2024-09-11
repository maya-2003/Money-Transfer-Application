package com.teamj.moneytransferapp.api.model

data class Transfer(
    val toAccountNumber: String,
    val amount: Int,
    val recipientName: String
)
