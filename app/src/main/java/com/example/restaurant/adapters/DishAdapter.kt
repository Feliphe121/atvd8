package com.example.restaurant.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.databinding.ItemDishBinding
import com.example.restaurant.models.Dish

class DishAdapter(
    private var dishes: List<Dish>,
    private val onDishClick: (Dish) -> Unit,
    private val onFavoriteClick: (Dish) -> Unit
) : RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    inner class DishViewHolder(private val binding: ItemDishBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dish: Dish) {
            binding.tvDishEmoji.text = dish.imageEmoji
            binding.tvDishName.text = dish.name
            binding.tvDishDescription.text = dish.description
            binding.tvDishPrice.text = "R$ %.2f".format(dish.price)
            binding.tvDishCategory.text = dish.category
            binding.tvDishRating.text = "%.1f".format(dish.rating)
            
            binding.btnFavorite.text = if (dish.isFavorite) "♥" else "♡"
            
            binding.root.setOnClickListener { onDishClick(dish) }
            binding.btnFavorite.setOnClickListener { onFavoriteClick(dish) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = ItemDishBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishes[position])
    }

    override fun getItemCount() = dishes.size

    fun updateDishes(newDishes: List<Dish>) {
        dishes = newDishes
        notifyDataSetChanged()
    }
}
