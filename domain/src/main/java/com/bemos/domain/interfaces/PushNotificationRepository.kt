package com.bemos.domain.interfaces

import com.bemos.domain.model.PushNotificationDomain

interface PushNotificationRepository {
    suspend fun sendPushNotification(
        token: String,
        projectId: String,
        notification: PushNotificationDomain
    ): Result<Unit>
}