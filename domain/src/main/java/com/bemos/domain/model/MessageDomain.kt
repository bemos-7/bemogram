package com.bemos.domain.model

data class MessageDomain(
    val chatId: String = "",
    val text: String = "",
    val senderId: String = ""
)