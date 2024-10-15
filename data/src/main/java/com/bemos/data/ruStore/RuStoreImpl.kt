package com.bemos.data.ruStore

import com.bemos.domain.interfaces.RuStoreRepository
import ru.rustore.sdk.universalpush.RuStoreUniversalPushClient
import javax.inject.Inject

class RuStoreImpl @Inject constructor(
    private val ruStore: RuStoreUniversalPushClient
) : RuStoreRepository {
    override fun ruStoreGetPushToken(onComplete: (String) -> Unit) {
        ruStore.getTokens().addOnSuccessListener { result ->
            onComplete(result.values.first())
        }
    }
}