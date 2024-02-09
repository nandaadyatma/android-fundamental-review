package com.example.coroutines2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

const val TAG = "D/MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tv_result)


        //penggunaan Coroutine context
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Call from thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                tvResult.text = answer
                Log.d(TAG, "Call from thread ${Thread.currentThread().name}")
            }

        }

    }
}

suspend fun doNetworkCall(): String {
    delay(10000L)
    return "This is the answer"
}