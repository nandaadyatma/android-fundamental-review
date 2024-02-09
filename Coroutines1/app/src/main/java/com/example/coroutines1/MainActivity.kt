package com.example.coroutines1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

const val TAG = "D/MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch { //scope
            delay(10000L) //mendelay coroutine, tidak mempengaruhi coroutine lain dan thread ini masih berjalan
            Log.d(TAG, "Coroutines says hello from ${Thread.currentThread().name} ") //DefaultDispatcher-worker-1
        }

        GlobalScope.launch {
            val call1 = doNetworkCall1();
            val call2 = doNetworkCall2();

            Log.d(TAG, call1);
            Log.d(TAG, call2);
        }



        Log.d(TAG, "haii from ${Thread.currentThread().name} ") //main
    }
}

suspend fun doNetworkCall1(): String {
    delay(3000L)
    return "This is the answer from call 1 from ${Thread.currentThread().name}"
}

suspend fun doNetworkCall2(): String {
    delay(4000L)
    return "This is the answer from call 2 from ${Thread.currentThread().name}"
}