package com.bemos.bemogram.data.firebase

import android.util.Log
import com.bemos.bemogram.domain.interfaces.FirebaseCloudMessagingRepository
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class FirebaseCloudMessagingImpl @Inject constructor(
    private val firebaseMessaging: FirebaseMessaging
) : FirebaseCloudMessagingRepository {
    override fun getFCMToken(onComplete: (String) -> Unit) {
        firebaseMessaging.token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d("FirebaseTokenMessaging", "Fetching FCM registration token failed", task.exception)
            }
            val token = task.result
            onComplete(token)
            Log.d("FirebaseTokenMessaging", token)
        })
    }
}