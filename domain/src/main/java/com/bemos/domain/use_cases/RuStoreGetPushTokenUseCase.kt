package com.bemos.domain.use_cases

import com.bemos.domain.interfaces.RuStoreRepository
import javax.inject.Inject


class RuStoreGetPushTokenUseCase @Inject constructor(
    private val repository: RuStoreRepository
) {
    fun execute(onComplete: (String) -> Unit) {
        repository.ruStoreGetPushToken(
            onComplete
        )
    }
}