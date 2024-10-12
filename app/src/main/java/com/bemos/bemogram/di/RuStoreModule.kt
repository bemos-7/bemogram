package com.bemos.bemogram.di

import com.bemos.bemogram.data.ruStore.RuStoreImpl
import com.bemos.bemogram.domain.interfaces.RuStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.rustore.sdk.universalpush.RuStoreUniversalPushClient

@Module
@InstallIn(SingletonComponent::class)
object RuStoreModule {

    @Provides
    fun provideRuStoreUniversalPushClient() : RuStoreUniversalPushClient {
        return RuStoreUniversalPushClient
    }

    @Provides
    fun provideRuStoreRepository(
        ruStore: RuStoreUniversalPushClient
    ) : RuStoreRepository {
        return RuStoreImpl(ruStore)
    }

}