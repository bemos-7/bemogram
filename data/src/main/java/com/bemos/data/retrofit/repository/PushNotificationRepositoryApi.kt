package com.bemos.data.retrofit.repository

import com.bemos.data.models.PushNotification
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PushNotificationRepositoryApi {
    @POST("v1/projects/{project_id}/messages:send")
    suspend fun sendPushNotification(
        @Header("Authorization") token: String,
        @Path("project_id") projectId: String,
        @Body notification: PushNotification
    ): Call<Void>
}