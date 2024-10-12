package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.data.retrofit.repository.PushNotificationRepositoryApi
import com.bemos.bemogram.domain.interfaces.PushNotificationRepository
import com.bemos.bemogram.domain.model.PushNotification
import javax.inject.Inject

class SendPushNotificationUseCase @Inject constructor(
    private val repository: PushNotificationRepository
) {
    suspend fun execute(pushNotification: PushNotification) : Result<Unit> {
       return repository.sendPushNotification(
           "",
           "",
           pushNotification
       )
    }
}