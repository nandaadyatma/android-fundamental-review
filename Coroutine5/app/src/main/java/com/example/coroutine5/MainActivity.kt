package com.example.coroutine5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

const val TAG = "MainActivity/D"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO){
            val time =
//                measureTimeMillis {
//                var value1: String? = null
//                var value2: String? = null
//
//                val job1 = launch { value1 = doNetworkCall1() }
//                val job2 = launch { value2 = doNetworkCall2() }
//
//                job1.join()
//                job2.join()
//
//                Log.d(TAG, "This is value 1: $value1")
//                Log.d(TAG, "This is value 2: $value2")
//
//            }

                measureTimeMillis {
                    var value1 = async { doNetworkCall1() }.await()
                    var value2 = async { doNetworkCall2() }

                    Log.d(TAG, "This is value 1: ${value1}")
                    Log.d(TAG, "This is value 2: ${value2.await()}")


                }

            Log.d(TAG, "the execution takes $time ms.")
        }



    }
}

suspend fun doNetworkCall1(): String {
    delay(3000L)
    return "Answer1"
}

suspend fun doNetworkCall2(): String {
    delay(3000L)
    return "Answer2"
}