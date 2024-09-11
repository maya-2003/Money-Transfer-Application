package com.teamj.moneytransferapp.api.model

data class UserData (
    val id: Int,
    val name: String,
    val email: String,
    val country: String,
    val dateOfBirth: String,
    val createdAt: String,
    val updatedAt: String,
    val accounts: List<UserAcountData>
)