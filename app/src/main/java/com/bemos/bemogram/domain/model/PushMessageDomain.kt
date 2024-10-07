package com.bemos.bemogram.domain.model

data class PushNotification(
    val message: Message
)

data class Message(
    val token: String,
    val notification: Notification,
    val android: AndroidNotification? = null
)

data class Notification(
    val title: String = "",
    val body: String = "",
    val image: String? = null
)

data class AndroidNotification(
    val notification: AndroidNotificationDetails
)

data class AndroidNotificationDetails(
    val title: String = "",
    val body: String = "",
    val image: String? = null,
    val click_action: String? = null,
    val click_action_type: Int? = null
)