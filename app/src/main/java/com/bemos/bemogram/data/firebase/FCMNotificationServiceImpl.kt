package com.bemos.bemogram.data.firebase

import com.bemos.bemogram.domain.interfaces.FCMNotificationServiceRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ru.rustore.sdk.universalpush.RuStoreUniversalPushManager
import ru.rustore.sdk.universalpush.UNIVERSAL_FCM_PROVIDER
import ru.rustore.sdk.universalpush.firebase.messaging.toUniversalRemoteMessage

class FCMNotificationServiceImpl : FCMNotificationServiceRepository, FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        RuStoreUniversalPushManager.processMessage(message.toUniversalRemoteMessage())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        RuStoreUniversalPushManager.processToken(UNIVERSAL_FCM_PROVIDER, token)
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
        RuStoreUniversalPushManager.processDeletedMessages(UNIVERSAL_FCM_PROVIDER)
    }
}