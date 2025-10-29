package com.example.restaurant.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val imageEmoji: String,
    val rating: Float,
    var isFavorite: Boolean = false
) : Parcelable
