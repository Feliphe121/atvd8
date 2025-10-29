package com.example.restaurant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.restaurant.data.DishRepository
import com.example.restaurant.databinding.FragmentDishDetailBinding

class DishDetailFragment : Fragment() {
    private var _binding: FragmentDishDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DishDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDishDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val dish = args.dish
        
        binding.tvDishEmoji.text = dish.imageEmoji
        binding.tvDishName.text = dish.name
        binding.tvDishDescription.text = dish.description
        binding.tvDishPrice.text = "R$ %.2f".format(dish.price)
        binding.tvDishCategory.text = dish.category
        binding.tvDishRating.text = "%.1f".format(dish.rating)
        
        binding.btnFavorite.text = if (dish.isFavorite) "Remover Favorito" else "Adicionar Favorito"
        
        binding.btnFavorite.setOnClickListener {
            DishRepository.toggleFavorite(dish.id)
            val updatedDish = DishRepository.getDishById(dish.id)
            binding.btnFavorite.text = if (updatedDish?.isFavorite == true) "Remover Favorito" else "Adicionar Favorito"
        }
        
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        
        binding.btnOrder.setOnClickListener {
            binding.btnOrder.text = "Pedido Realizado!"
            binding.btnOrder.isEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
