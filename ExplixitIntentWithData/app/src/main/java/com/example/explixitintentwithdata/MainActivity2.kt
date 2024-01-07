package com.example.explixitintentwithdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.explixitintentwithdata.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("NAME")
        val greetings = "Hello $name"

        binding.tvGreeting.text = greetings


    }
}