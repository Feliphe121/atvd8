package com.example.restaurant.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.restaurant.models.Dish
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DishDetailFragmentArgs(
  public val dish: Dish,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Dish::class.java)) {
      result.set("dish", this.dish as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Dish::class.java)) {
      result.set("dish", this.dish as Serializable)
    } else {
      throw UnsupportedOperationException(Dish::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DishDetailFragmentArgs {
      bundle.setClassLoader(DishDetailFragmentArgs::class.java.classLoader)
      val __dish : Dish?
      if (bundle.containsKey("dish")) {
        if (Parcelable::class.java.isAssignableFrom(Dish::class.java) ||
            Serializable::class.java.isAssignableFrom(Dish::class.java)) {
          __dish = bundle.get("dish") as Dish?
        } else {
          throw UnsupportedOperationException(Dish::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__dish == null) {
          throw IllegalArgumentException("Argument \"dish\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dish\" is missing and does not have an android:defaultValue")
      }
      return DishDetailFragmentArgs(__dish)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DishDetailFragmentArgs {
      val __dish : Dish?
      if (savedStateHandle.contains("dish")) {
        if (Parcelable::class.java.isAssignableFrom(Dish::class.java) ||
            Serializable::class.java.isAssignableFrom(Dish::class.java)) {
          __dish = savedStateHandle.get<Dish?>("dish")
        } else {
          throw UnsupportedOperationException(Dish::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__dish == null) {
          throw IllegalArgumentException("Argument \"dish\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dish\" is missing and does not have an android:defaultValue")
      }
      return DishDetailFragmentArgs(__dish)
    }
  }
}
