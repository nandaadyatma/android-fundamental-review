package com.example.rabbitapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.rabbitapp.data.remote.api.ApiConfig
import com.example.rabbitapp.data.remote.api.ApiService
import com.example.rabbitapp.data.remote.response.RabbitResponse
import com.example.rabbitapp.data.result.Result
import retrofit2.HttpException

class Repository private constructor(private val apiService: ApiService){
    fun getRabbit(): LiveData<Result<RabbitResponse>> = liveData {
        emit(Result.Loading)
        try {
            val apiService = ApiConfig.getApiService()
            val rabbitResponse = apiService.getRabbit()
            if (rabbitResponse != null){
                emit(Result.Success(rabbitResponse))
            } else {
                emit(Result.Error("Error"))
            }
        } catch (e: Exception){
            emit(Result.Error("Error"))
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            apiService: ApiService
        ): Repository =
            instance ?: synchronized(this){
                instance ?: Repository(apiService)
            }.also { instance = it }
    }
}