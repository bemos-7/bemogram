package com.bemos.bemogram.app

import android.app.Application
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.initialize
import dagger.hilt.android.HiltAndroidApp
import ru.rustore.sdk.pushclient.common.logger.DefaultLogger
import ru.rustore.sdk.universalpush.RuStoreUniversalPushClient
import ru.rustore.sdk.universalpush.firebase.provides.FirebasePushProvider
import ru.rustore.sdk.universalpush.rustore.providers.RuStorePushProvider

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)

        RuStoreUniversalPushClient.init(
            context = this,
            rustore = RuStorePushProvider(
                application = this,
                projectId = "CYJdN6nqjx2LarazPw5hAQNwXF36xbZY",
                logger = DefaultLogger(tag = "bemogram")
            ),
            firebase = FirebasePushProvider(
                context = this
            )
        )
        RuStoreUniversalPushClient.getTokens()
            .addOnSuccessListener { result ->
                Log.d("RuStoreTest", "get tokens success $result")
            }
            .addOnFailureListener { throwable ->
                Log.e("RuStoreTest", "get tokens error: $throwable")
            }
    }
}