package com.bemos.bemogram.domain.interfaces

interface RuStoreRepository {

    fun ruStoreGetPushToken(onComplete: (String) -> Unit)

}