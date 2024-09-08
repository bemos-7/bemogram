package com.bemos.bemogram.domain.model

data class UserDomain(
    val userId: String? = null,
    val username: String? = null,
    val bio: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val email: String,
    val password: String
)