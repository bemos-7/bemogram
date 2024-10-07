package com.bemos.bemogram.data.retrofit

import com.bemos.bemogram.data.retrofit.repository.PushNotificationRepositoryApi
import com.bemos.bemogram.domain.interfaces.PushNotificationRepository
import com.bemos.bemogram.domain.model.PushNotification
import com.bemos.bemogram.utils.Constants.PROJECT_ID
import com.bemos.bemogram.utils.Constants.SERVICES_TOKEN
import javax.inject.Inject

class PushNotificationImpl @Inject constructor(
    private val api: PushNotificationRepositoryApi
) : PushNotificationRepository {
    override fun sendPushNotification(
        token: String,
        projectId: String,
        notification: PushNotification
    ): Result<Unit> {
        return try {
            val call = api.sendPushNotification("Bearer $SERVICES_TOKEN", PROJECT_ID, notification)
            call.execute()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}