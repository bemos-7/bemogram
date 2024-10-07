package com.bemos.bemogram.di

import com.bemos.bemogram.data.retrofit.PushNotificationImpl
import com.bemos.bemogram.data.retrofit.repository.PushNotificationRepositoryApi
import com.bemos.bemogram.domain.interfaces.PushNotificationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideNotificationRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://vkpns.rustore.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePushNotificationRepositoryApi(
        retrofit: Retrofit
    ) : PushNotificationRepositoryApi {
        return retrofit.create(PushNotificationRepositoryApi::class.java)
    }

    @Provides
    fun providePushNotificationRepository(
        api: PushNotificationRepositoryApi
    ) : PushNotificationRepository {
        return PushNotificationImpl(api)
    }

}