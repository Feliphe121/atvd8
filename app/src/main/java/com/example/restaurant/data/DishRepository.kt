package com.example.restaurant.data

import com.example.restaurant.models.Dish

object DishRepository {
    private val dishes = mutableListOf(
        Dish(1, "Margherita Pizza", "Tomate fresco, mozzarella e manjericão", 42.90, "Pizza", "🍕", 4.8f),
        Dish(2, "Carbonara", "Massa com bacon, ovos e queijo parmesão", 38.50, "Massas", "🍝", 4.7f),
        Dish(3, "Hambúrguer Artesanal", "180g de carne com queijo cheddar e bacon", 35.00, "Hambúrgueres", "🍔", 4.9f),
        Dish(4, "Sushi Combo", "20 peças variadas de sushi e sashimi", 89.90, "Japonês", "🍣", 4.6f),
        Dish(5, "Frango Grelhado", "Peito de frango com legumes e arroz integral", 32.00, "Saudável", "🍗", 4.5f),
        Dish(6, "Caesar Salad", "Alface romana, croutons, parmesão e molho Caesar", 28.90, "Saladas", "🥗", 4.4f),
        Dish(7, "Taco Mexicano", "3 tacos com carne, guacamole e pico de gallo", 36.50, "Mexicano", "🌮", 4.7f),
        Dish(8, "Ramen Tradicional", "Caldo de porco, macarrão, ovo e vegetais", 45.00, "Japonês", "🍜", 4.8f),
        Dish(9, "Burrito", "Tortilha recheada com carne, feijão e queijo", 34.90, "Mexicano", "🌯", 4.6f),
        Dish(10, "Lasanha Bolonhesa", "Camadas de massa com molho bolonhesa e queijo", 42.00, "Massas", "🍝", 4.7f),
        Dish(11, "Hot Dog Gourmet", "Salsicha artesanal com batata palha e molhos", 25.00, "Fast Food", "🌭", 4.5f),
        Dish(12, "Wrap de Frango", "Tortilha integral com frango grelhado e salada", 29.90, "Saudável", "🌯", 4.4f),
        Dish(13, "Bife à Parmegiana", "Bife empanado com molho e queijo derretido", 48.00, "Carnes", "🥩", 4.9f),
        Dish(14, "Risoto de Funghi", "Risoto cremoso com mix de cogumelos", 44.50, "Massas", "🍚", 4.6f),
        Dish(15, "Curry Tailandês", "Frango ao curry com leite de coco e arroz", 39.90, "Asiático", "🍛", 4.7f),
        Dish(16, "Tiramisu", "Sobremesa italiana com café e mascarpone", 22.00, "Sobremesas", "🍰", 4.8f),
        Dish(17, "Brownie com Sorvete", "Brownie quente com sorvete de baunilha", 18.50, "Sobremesas", "🍫", 4.7f),
        Dish(18, "Açaí Bowl", "Açaí com granola, banana e mel", 24.90, "Sobremesas", "🍨", 4.5f)
    )

    fun getAllDishes(): List<Dish> = dishes

    fun getDishById(id: Int): Dish? = dishes.find { it.id == id }

    fun getFavoriteDishes(): List<Dish> = dishes.filter { it.isFavorite }

    fun toggleFavorite(dishId: Int) {
        dishes.find { it.id == dishId }?.let {
            it.isFavorite = !it.isFavorite
        }
    }

    fun getDishesByCategory(category: String): List<Dish> {
        return if (category == "Todos") dishes else dishes.filter { it.category == category }
    }

    fun getCategories(): List<String> {
        return listOf("Todos") + dishes.map { it.category }.distinct()
    }
}
