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
import com.example.restaurant.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var dishAdapter: DishAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadFavorites()
    }

    private fun setupRecyclerView() {
        dishAdapter = DishAdapter(
            dishes = emptyList(),
            onDishClick = { dish ->
                val action = FavoritesFragmentDirections.actionFavoritesToDetail(dish)
                findNavController().navigate(action)
            },
            onFavoriteClick = { dish ->
                DishRepository.toggleFavorite(dish.id)
                loadFavorites()
            }
        )
        binding.rvFavoriteDishes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavoriteDishes.adapter = dishAdapter
    }

    private fun loadFavorites() {
        val favorites = DishRepository.getFavoriteDishes()
        dishAdapter.updateDishes(favorites)
        binding.tvEmptyState.visibility = if (favorites.isEmpty()) View.VISIBLE else View.GONE
        binding.rvFavoriteDishes.visibility = if (favorites.isEmpty()) View.GONE else View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
