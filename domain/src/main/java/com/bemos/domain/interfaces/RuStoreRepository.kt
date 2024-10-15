package com.bemos.domain.interfaces

interface RuStoreRepository {

    fun ruStoreGetPushToken(onComplete: (String) -> Unit)

}