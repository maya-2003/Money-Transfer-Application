package com.maya.moneytransferapp

data class Transaction(
    val name: String,
    val cardType: String,
    val cardNumber: String,
    val time: String,
    val amount: String
)
