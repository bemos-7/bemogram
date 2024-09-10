package com.bemos.bemogram.domain.model

data class UserDomain(
    var userId: String? = "",
    var username: String? = "",
    var bio: String? = "",
    var imageUrl: String? = "",
    var name: String? = "",
    var surname: String? = "",
    var following: List<String>? = emptyList(),
    var followers: List<String>? = emptyList(),
    var publications: List<Int>? = emptyList(),
    var totalPosts: String? = "",
    var url: String? = "",
    var email: String = "",
    var password: String = ""
)