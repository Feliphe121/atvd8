package com.example.restaurant.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.restaurant.R
import com.example.restaurant.models.Dish
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FavoritesFragmentDirections private constructor() {
  private data class ActionFavoritesToDetail(
    public val dish: Dish,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_favorites_to_detail

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Dish::class.java)) {
          result.putParcelable("dish", this.dish as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Dish::class.java)) {
          result.putSerializable("dish", this.dish as Serializable)
        } else {
          throw UnsupportedOperationException(Dish::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionFavoritesToDetail(dish: Dish): NavDirections = ActionFavoritesToDetail(dish)
  }
}
