package com.example.navigationlearning2.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _name = mutableStateOf("")
    val name = _name

    fun changeName(name: String){
        _name.value = name
    }
}