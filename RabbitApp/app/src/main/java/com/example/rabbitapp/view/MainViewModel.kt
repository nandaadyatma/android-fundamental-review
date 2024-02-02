package com.example.rabbitapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.livedata.ktx.R
import com.example.rabbitapp.data.remote.response.RabbitResponse
import com.example.rabbitapp.data.repository.Repository
import com.example.rabbitapp.data.result.Result

class MainViewModel(private val repository: Repository) : ViewModel() {

    private var rabbitData: RabbitResponse? = null
    private set

    fun setRabbit(rabbit: RabbitResponse) {
        rabbitData = rabbit
    }


    fun getCurrentRabbit(): RabbitResponse{
        return rabbitData!!
    }
    fun getRabbit() = repository.getRabbit()
}