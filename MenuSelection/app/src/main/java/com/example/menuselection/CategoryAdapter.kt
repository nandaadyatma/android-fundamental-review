package com.example.menuselection


import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.menuselection.data_class.CategoryItem
import com.example.menuselection.databinding.CategoryItemBinding

class CategoryAdapter(private val context: Context) :
    ListAdapter<CategoryItem, CategoryAdapter.MyViewHolder>(
        DIFF_CALLBACK
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
        holder.itemView.setOnClickListener {
//            val moveStoryDataIntent =
//                Intent(holder.itemView.context, DetailStoryActivity::class.java)
//            moveStoryDataIntent.putExtra(DetailStoryActivity.ID, story.id)
//
//            val optionsCompat: ActivityOptionsCompat =
//                ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    holder.itemView.context as Activity,
//                    Pair(holder.binding.ivItemPhoto, "storyImage")
//                )
//            context.startActivity(moveStoryDataIntent, optionsCompat.toBundle())

            CategoryActivity.selectedCategory = it.id

        }

        if (CategoryActivity.selectedCategory == holder.itemView.id){
            holder.binding.cardCategoryItem.strokeColor = Color.BLUE
        }
    }

    class MyViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryItem) {
            binding.tvCategoryNameItem.text = category.name

        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CategoryItem>() {
            override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CategoryItem,
                newItem: CategoryItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}