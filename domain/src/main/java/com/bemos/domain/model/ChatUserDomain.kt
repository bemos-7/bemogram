package com.bemos.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatUserDomain(
    val user: UserDomain,
    val chatId: String
) : Parcelable