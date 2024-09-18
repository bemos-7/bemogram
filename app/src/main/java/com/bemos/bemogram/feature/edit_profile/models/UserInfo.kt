package com.bemos.bemogram.feature.edit_profile.models

import android.net.Uri

data class UserInfo(
    val name: String,
    val surname: String,
    val userImage: Uri? = null
)