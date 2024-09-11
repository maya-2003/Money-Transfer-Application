package com.teamj.moneytransferapp.api.model

data class User(
    val name: String,
    val country: String,
    val email: String,
    val password: String,
    val dateOfBirth: String
)
