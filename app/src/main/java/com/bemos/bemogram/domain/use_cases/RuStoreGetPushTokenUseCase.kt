package com.bemos.bemogram.domain.use_cases

import com.bemos.bemogram.domain.interfaces.RuStoreRepository
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