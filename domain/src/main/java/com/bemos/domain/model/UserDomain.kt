package com.bemos.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDomain(
    var userId: String? = "",
    var username: String? = "",
    var bio: String? = "",
    var imageUrl: String? = "",
    var name: String? = "",
    var surname: String? = "",
    var notificationToken: String? = "",
    var following: List<String>? = emptyList(),
    var followers: List<String>? = emptyList(),
    var publications: List<Int>? = emptyList(),
    var totalPosts: String? = "",
    var url: String? = "",
    var email: String = "",
    var password: String = ""
) : Parcelable