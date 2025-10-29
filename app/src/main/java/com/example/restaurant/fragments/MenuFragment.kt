package com.example.restaurant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.restaurant.adapters.DishAdapter
import com.example.restaurant.data.DishRepository
import com.example.restaurant.databinding.FragmentMenuBinding
import com.google.android.material.chip.Chip

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private lateinit var dishAdapter: DishAdapter
    private var selectedCategory = "Todos"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategoryChips()
        setupRecyclerView()
        loadDishes()
    }

    private fun setupCategoryChips() {
        val categories = DishRepository.getCategories()
        categories.forEach { category ->
            val chip = Chip(requireContext())
            chip.text = category
            chip.isCheckable = true
            chip.isChecked = category == "Todos"
            chip.setOnClickListener {
                selectedCategory = category
                loadDishes()
            }
            binding.chipGroupCategories.addView(chip)
        }
    }

    private fun setupRecyclerView() {
        dishAdapter = DishAdapter(
            dishes = emptyList(),
            onDishClick = { dish ->
                val action = MenuFragmentDirections.actionMenuToDetail(dish)
                findNavController().navigate(action)
            },
            onFavoriteClick = { dish ->
                DishRepository.toggleFavorite(dish.id)
                dishAdapter.notifyDataSetChanged()
            }
        )
        binding.rvMenuDishes.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMenuDishes.adapter = dishAdapter
    }

    private fun loadDishes() {
        val dishes = DishRepository.getDishesByCategory(selectedCategory)
        dishAdapter.updateDishes(dishes)
        binding.tvDishCount.text = "${dishes.size} pratos"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
