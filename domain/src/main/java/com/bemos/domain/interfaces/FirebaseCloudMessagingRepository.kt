package com.bemos.domain.interfaces

interface FirebaseCloudMessagingRepository {

    fun getFCMToken(onComplete: (String) -> Unit)

}