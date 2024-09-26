package com.bemos.bemogram.domain.model

data class ChatUserDomain(
    val user: UserDomain,
    val chatId: String
)