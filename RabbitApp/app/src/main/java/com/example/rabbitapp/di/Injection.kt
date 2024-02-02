package com.example.rabbitapp.di

import android.content.Context
import com.example.rabbitapp.data.remote.api.ApiConfig
import com.example.rabbitapp.data.repository.Repository
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}