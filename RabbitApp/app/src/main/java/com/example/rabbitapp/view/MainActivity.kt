package com.example.rabbitapp.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.rabbitapp.R
import com.example.rabbitapp.data.result.Result
import com.example.rabbitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        if (viewModel.getCurrentRabbit() == null){
//            setRabbit()
//        } else {
//            val rabbit = viewModel.getCurrentRabbit()
//            binding.rabbitDescription.text = rabbit.description
//            binding.rabbitNameTv.text = rabbit.name
//            Glide.with(this)
//                .load(rabbit.imageUrl)
//                .into(binding.rabbitImg)
//        }

        setRabbit()
    }

    fun setRabbit(){
        viewModel.getRabbit().observe(this){ rabbit ->
            if (rabbit != null){
                when(rabbit){
                    is Result.Loading -> {
                        binding.card.visibility = View.GONE
                        showLoading(true)
                    }
                    is Result.Success -> {
                        binding.card.visibility = View.VISIBLE
                        showLoading(false)
                        binding.apply {
                            rabbitNameTv.text = rabbit.data.name;
                            rabbitDescription.text = rabbit.data.description
                            Glide.with(this@MainActivity)
                                .load(rabbit.data.imageUrl)
                                .into(binding.rabbitImg)
                        }

                    }

                    is Result.Error -> {
                        showLoading(false)
                        binding.card.visibility = View.GONE
                    }
                }
            }

        }
    }

    fun showLoading(isLoading: Boolean){
        binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}