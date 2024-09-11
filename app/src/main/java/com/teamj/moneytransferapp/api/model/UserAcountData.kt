package com.teamj.moneytransferapp.api.model

data class UserAcountData(
    val id: Int,
    val accountNumber: String,
    val balance: Int,
    val accountName: String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)
