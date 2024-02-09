package com.example.coroutines3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        GlobalScope.launch(Dispatchers.Main){
        tvResult.text = "Loading..."
            delay(2000L)
                tvResult.text = doNetworkCall()



        }

    }

}

suspend fun doNetworkCall(): String{
    delay(5000L)
    return "This is the result"
}