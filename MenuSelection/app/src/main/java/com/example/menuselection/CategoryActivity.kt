package com.example.menuselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menuselection.data_class.CategoryItem
import com.example.menuselection.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoryBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = listOf<CategoryItem>(
            CategoryItem(id = 1, name = "Kendaraan", data = "Kendaraan"),
            CategoryItem(id = 2, name = "Pakaian", data = "Pakaian"),
            CategoryItem(id = 1, name = "Makanan", data = "Makanan"),
        )

        setCategoriesRv(data)


    }
    private fun setCategoriesRv(data: List<CategoryItem>){
        val layoutManager = LinearLayoutManager(this@CategoryActivity)

        val rvCategories = binding.rvCategories

        rvCategories.layoutManager = layoutManager

        val adapter = CategoryAdapter(this@CategoryActivity)
        adapter.submitList(data)

        rvCategories.adapter = adapter


    }

    companion object {
        var selectedCategory = 0
    }

}

