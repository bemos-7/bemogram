package com.bemos.bemogram.domain.interfaces

import com.bemos.bemogram.domain.model.PushNotification
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PushNotificationRepository {
    fun sendPushNotification(
        token: String,
        projectId: String,
        notification: PushNotification
    ): Result<Unit>
}