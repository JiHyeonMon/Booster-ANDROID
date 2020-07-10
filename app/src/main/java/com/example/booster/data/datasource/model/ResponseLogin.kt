package com.example.booster.data.datasource.model

data class ResponseLogin(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: LoginToken
)

data class LoginToken(
    val accessToken: String
)