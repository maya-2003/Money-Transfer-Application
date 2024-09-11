package com.teamj.moneytransferapp.api.model

data class UserLoginResp(
    val id: Int,
    val token: String,
    val tokenType: String,
    val message: String,
    val status: String
)
