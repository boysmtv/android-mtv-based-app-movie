package com.mtv.app.movie.feature.login.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val userId: Int,
    val firstName: String,
    val lastName: String,
    val lastLogin: String
)