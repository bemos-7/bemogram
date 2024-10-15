package com.bemos.data.di

import com.bemos.data.retrofit.PushNotificationImpl
import com.bemos.data.retrofit.repository.PushNotificationRepositoryApi
import com.bemos.domain.interfaces.PushNotificationRepository
import com.bemos.shared.Constants.SEND_PUSH_NOTIFICATION_URL
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
            .baseUrl(SEND_PUSH_NOTIFICATION_URL)
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