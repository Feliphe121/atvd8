package com.example.restaurant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurant.adapters.DishAdapter
import com.example.restaurant.data.DishRepository
import com.example.restaurant.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var dishAdapter: DishAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadPopularDishes()
    }

    private fun setupRecyclerView() {
        dishAdapter = DishAdapter(
            dishes = emptyList(),
            onDishClick = { dish ->
                val action = HomeFragmentDirections.actionHomeToDetail(dish)
                findNavController().navigate(action)
            },
            onFavoriteClick = { dish ->
                DishRepository.toggleFavorite(dish.id)
                dishAdapter.notifyDataSetChanged()
            }
        )
        binding.rvPopularDishes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPopularDishes.adapter = dishAdapter
    }

    private fun loadPopularDishes() {
        val popularDishes = DishRepository.getAllDishes().sortedByDescending { it.rating }.take(6)
        dishAdapter.updateDishes(popularDishes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
