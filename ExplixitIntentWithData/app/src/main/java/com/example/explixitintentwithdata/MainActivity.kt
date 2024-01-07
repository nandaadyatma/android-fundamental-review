package com.example.explixitintentwithdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.explixitintentwithdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nameEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            next()
        }


    }
    private fun next(){
        nameEditText = binding.edtName
        val name = nameEditText.text.toString().trim()

        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra("NAME", name)
        startActivity(intent)
    }
}