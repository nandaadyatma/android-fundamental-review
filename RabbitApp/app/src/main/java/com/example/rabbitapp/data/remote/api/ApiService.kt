package com.example.rabbitapp.data.remote.api

import com.example.rabbitapp.data.remote.response.RabbitResponse
import retrofit2.http.GET

interface ApiService {
    @GET("randomrabbit")
    suspend fun getRabbit(): RabbitResponse
}