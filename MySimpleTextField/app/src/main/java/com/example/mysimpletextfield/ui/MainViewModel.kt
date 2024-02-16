package com.example.mysimpletextfield.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _text = mutableStateOf("")
    val text: State<String> = _text

    private var _listTask = mutableStateListOf<String>()
    val listTask= _listTask

    fun addTask(task: String){
        _listTask.add(task)
    }

    fun onTextChange(changes: String){
        _text.value = changes
    }
    private var _checked = mutableStateOf(false)
    val checked: State<Boolean> = _checked

    fun onCheckChange(changes: Boolean){
        _checked.value = changes
    }
}