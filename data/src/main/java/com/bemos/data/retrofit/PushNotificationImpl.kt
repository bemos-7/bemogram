package com.bemos.data.retrofit

import com.bemos.data.mappers.PushMessage.toPushNotification
import com.bemos.data.retrofit.repository.PushNotificationRepositoryApi
import com.bemos.domain.interfaces.PushNotificationRepository
import com.bemos.domain.model.PushNotificationDomain
import com.bemos.shared.Constants.PROJECT_ID
import com.bemos.shared.Constants.SERVICES_TOKEN
import javax.inject.Inject

class PushNotificationImpl @Inject constructor(
    private val api: PushNotificationRepositoryApi
) : PushNotificationRepository {
    override suspend fun sendPushNotification(
        token: String,
        projectId: String,
        notification: PushNotificationDomain
    ): Result<Unit> {
        return try {

            val call = api.sendPushNotification("Bearer $SERVICES_TOKEN", PROJECT_ID, toPushNotification(notification))
            call.execute()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}