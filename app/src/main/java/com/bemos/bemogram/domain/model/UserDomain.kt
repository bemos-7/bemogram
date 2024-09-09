package com.bemos.bemogram.domain.model

data class UserDomain(
    val userId: String? = null,
    val username: String? = null,
    val bio: String? = null,
    val imageUrl: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val following: List<String>? = emptyList(),
    val followers: List<String>? = emptyList(),
    val totalPosts: String? = null,
    val url: String? = null,
    val email: String,
    val password: String
)