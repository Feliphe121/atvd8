package com.example.restaurant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.restaurant.data.DishRepository
import com.example.restaurant.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadUserStats()
    }

    private fun loadUserStats() {
        val totalDishes = DishRepository.getAllDishes().size
        val favoritesCount = DishRepository.getFavoriteDishes().size
        val categories = DishRepository.getCategories().size - 1

        binding.tvTotalDishes.text = totalDishes.toString()
        binding.tvFavoritesCount.text = favoritesCount.toString()
        binding.tvCategoriesCount.text = categories.toString()
    }

    override fun onResume() {
        super.onResume()
        loadUserStats()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
