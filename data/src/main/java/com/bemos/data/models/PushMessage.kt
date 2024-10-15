package com.bemos.data.models

data class PushNotification(
    val message: MessageUser
)

data class MessageUser(
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