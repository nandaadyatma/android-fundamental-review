package com.example.coroutines4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

const val TAG = "MainActivity/D"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "THis is from ${Thread.currentThread().name}")
        Log.d(TAG, "This is from ${CoroutineName}")
        GlobalScope.launch(Dispatchers.Main){
            Log.d(TAG, "Hello is from ${Thread.currentThread().name}")
            Log.d(TAG, "Hello is from ${CoroutineName}")
            launch() {
                delay(2000L)
                Log.d(TAG, "Coroutine 1")

            }
            launch(Dispatchers.Main) {
                Log.d(TAG, "Coroutine 2")
            }
            Log.d(TAG, "Hey is from ${CoroutineName}")
        }
    }
}