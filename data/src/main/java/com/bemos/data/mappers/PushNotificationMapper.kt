package com.bemos.data.mappers

import com.bemos.data.models.AndroidNotification
import com.bemos.data.models.AndroidNotificationDetails
import com.bemos.data.models.MessageUser
import com.bemos.data.models.Notification
import com.bemos.data.models.PushNotification
import com.bemos.domain.model.AndroidNotificationDetailsDomain
import com.bemos.domain.model.AndroidNotificationDomain
import com.bemos.domain.model.MessageUserDomain
import com.bemos.domain.model.NotificationDomain
import com.bemos.domain.model.PushNotificationDomain

object PushNotificationMapper {

    fun toDomain(pushNotification: PushNotification) : PushNotificationDomain {
        return PushNotificationDomain(
            messageUserDomain = toDomain(pushNotification.message)
        )
    }

    fun toPushNotification(pushNotificationDomain: PushNotificationDomain) : PushNotification {
        return PushNotification(
            message = toPushNotification(pushNotificationDomain.messageUserDomain)
        )
    }

    private fun toDomain(messageUser: MessageUser) : MessageUserDomain {
        return MessageUserDomain(
            token = messageUser.token,
            notificationDomain = toDomain(messageUser.notification),
            android = messageUser.android?.let { toDomain(it) }
        )
    }

    private fun toDomain(notification: Notification) : NotificationDomain {
        return NotificationDomain(
            title = notification.title,
            body = notification.body,
            image = notification.image
        )
    }

    private fun toDomain(androidNotification: AndroidNotification) : AndroidNotificationDomain {
        return AndroidNotificationDomain(
            notification = toDomain(androidNotification.notification)
        )
    }

    private fun toDomain(androidNotificationDetails: AndroidNotificationDetails) : AndroidNotificationDetailsDomain {
        return AndroidNotificationDetailsDomain(
            title = androidNotificationDetails.title,
            body = androidNotificationDetails.body,
            image = androidNotificationDetails.image,
            click_action = androidNotificationDetails.click_action,
            click_action_type = androidNotificationDetails.click_action_type
        )
    }

    private fun toPushNotification(messageUserDomain: MessageUserDomain) : MessageUser {
        return MessageUser(
            token = messageUserDomain.token,
            notification = toPushNotification(messageUserDomain.notificationDomain),
            android = messageUserDomain.android?.let { toPushNotification(it) }
        )
    }

    private fun toPushNotification(notificationDomain: NotificationDomain) : Notification {
        return Notification(
            title = notificationDomain.title,
            body = notificationDomain.body,
            image = notificationDomain.image
        )
    }

    private fun toPushNotification(androidNotificationDomain: AndroidNotificationDomain) : AndroidNotification {
        return AndroidNotification(
            notification = toPushNotification(androidNotificationDomain.notification)
        )
    }

    private fun toPushNotification(androidNotificationDetailsDomain: AndroidNotificationDetailsDomain) : AndroidNotificationDetails {
        return AndroidNotificationDetails(
            title = androidNotificationDetailsDomain.title,
            body = androidNotificationDetailsDomain.body,
            image = androidNotificationDetailsDomain.image,
            click_action = androidNotificationDetailsDomain.click_action,
            click_action_type = androidNotificationDetailsDomain.click_action_type
        )
    }
}