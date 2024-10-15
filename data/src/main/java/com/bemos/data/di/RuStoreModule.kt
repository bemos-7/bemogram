package com.bemos.data.di

import com.bemos.domain.interfaces.RuStoreRepository
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
        return com.bemos.data.ruStore.RuStoreImpl(ruStore)
    }

}