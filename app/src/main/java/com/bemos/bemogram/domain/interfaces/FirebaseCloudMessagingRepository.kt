package com.bemos.bemogram.domain.interfaces

interface FirebaseCloudMessagingRepository {

    fun getFCMToken(onComplete: (String) -> Unit)

}