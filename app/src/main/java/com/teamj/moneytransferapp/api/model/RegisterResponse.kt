package com.teamj.moneytransferapp.api.model

data class RegisterResponse(
    val id: Int,
    val name: String,
    val email: String,
    val country: String,
    val createdAt: String,
    val updatedAt: String
)
