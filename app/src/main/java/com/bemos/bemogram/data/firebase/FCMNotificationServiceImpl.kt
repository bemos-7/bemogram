package com.bemos.bemogram.data.firebase

import com.bemos.bemogram.domain.interfaces.FCMNotificationServiceRepository
import com.google.firebase.messaging.FirebaseMessagingService

class FCMNotificationServiceImpl : FCMNotificationServiceRepository, FirebaseMessagingService() {
}