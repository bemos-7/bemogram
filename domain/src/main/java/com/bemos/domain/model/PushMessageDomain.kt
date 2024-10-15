package com.bemos.domain.model

data class PushNotificationDomain(
    val messageUserDomain: MessageUserDomain
)

data class MessageUserDomain(
    val token: String,
    val notificationDomain: NotificationDomain,
    val android: AndroidNotificationDomain? = null
)

data class NotificationDomain(
    val title: String = "",
    val body: String = "",
    val image: String? = null
)

data class AndroidNotificationDomain(
    val notification: AndroidNotificationDetailsDomain
)

data class AndroidNotificationDetailsDomain(
    val title: String = "",
    val body: String = "",
    val image: String? = null,
    val click_action: String? = null,
    val click_action_type: Int? = null
)