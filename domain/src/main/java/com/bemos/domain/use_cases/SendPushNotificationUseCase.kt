package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.PushNotificationRepository
import com.bemos.domain.model.PushNotificationDomain
import javax.inject.Inject


class SendPushNotificationUseCase @Inject constructor(
    private val repository: PushNotificationRepository
) {
    suspend fun execute(pushNotificationDomain: PushNotificationDomain) : Result<Unit> {
       return repository.sendPushNotification(
           "",
           "",
           pushNotificationDomain
       )
    }
}