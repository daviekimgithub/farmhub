package com.ernestgichiri.farmhub.data.json

import android.util.Log
import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.utils.ReadJSONFromAssets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.internal.readJson

class JsonDataLoader() {
    fun loadProductEntities(): Flow<NetworkResponseState<List<ProductEntity>>> = flow {
        emit(NetworkResponseState.Loading) // Emit loading state
        try {
            val productEntities = withContext(Dispatchers.IO) {
                val productList = listOf(
                    ProductEntity(
                        id = 35,
                        title = "Potatoes",
                        description = "Versatile and starchy potatoes, great for roasting, mashing, or as a side dish.",
                        price = 2.29,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Potatoes/1.png",
                        rating = 4.2
                    ),
                    ProductEntity(
                        id = 33,
                        title = "Mulberry",
                        description = "Sweet and juicy mulberries, perfect for snacking or adding to desserts and cereals.",
                        price = 4.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Mulberry/1.png",
                        rating = 4.6
                    ),
                    ProductEntity(
                        id = 16,
                        title = "Apple",
                        description = "Fresh and crisp apples, perfect for snacking or incorporating into various recipes.",
                        price = 1.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Apple/1.png",
                        rating = 4.1
                    ),
                    ProductEntity(
                        id = 19,
                        title = "Chicken Meat",
                        description = "Fresh and tender chicken meat, suitable for various culinary preparations.",
                        price = 9.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Chicken%20Meat/1.png",
                        rating = 4.5
                    ),
                    ProductEntity(
                        id = 23,
                        title = "Eggs",
                        description = "Fresh eggs, a versatile ingredient for baking, cooking, or breakfast.",
                        price = 2.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Eggs/1.png",
                        rating = 4.0
                    ),
                    ProductEntity(
                        id = 24,
                        title = "Fish Steak",
                        description = "Quality fish steak, suitable for grilling, baking, or pan-searing.",
                        price = 14.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Fish%20Steak/1.png",
                        rating = 4.6
                    ),
                    ProductEntity(
                        id = 25,
                        title = "Green Bell Pepper",
                        description = "Fresh and vibrant green bell pepper, perfect for adding color and flavor to your dishes.",
                        price = 1.29,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Green%20Bell%20Pepper/1.png",
                        rating = 4.1
                    ),
                    ProductEntity(
                        id = 26,
                        title = "Green Chili Pepper",
                        description = "Spicy green chili pepper, ideal for adding heat to your favorite recipes.",
                        price = 0.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Green%20Chili%20Pepper/1.png",
                        rating = 3.7
                    ),
                    ProductEntity(
                        id = 30,
                        title = "Kiwi",
                        description = "Nutrient-rich kiwi, perfect for snacking or adding a tropical twist to your dishes.",
                        price = 2.49,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Kiwi/1.png",
                        rating = 4.2
                    ),
                    ProductEntity(
                        id = 31,
                        title = "Lemon",
                        description = "Zesty and tangy lemons, versatile for cooking, baking, or making refreshing beverages.",
                        price = 0.79,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Lemon/1.png",
                        rating = 4.3
                    ),
                    ProductEntity(
                        id = 32,
                        title = "Milk",
                        description = "Fresh and nutritious milk, a staple for various recipes and daily consumption.",
                        price = 3.49,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Milk/1.png",
                        rating = 4.5
                    ),
                    ProductEntity(
                        id = 17,
                        title = "Beef Steak",
                        description = "High-quality beef steak, great for grilling or cooking to your preferred level of doneness.",
                        price = 12.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Beef%20Steak/1.png",
                        rating = 4.7
                    ),
                    ProductEntity(
                        id = 18,
                        title = "Cat Food",
                        description = "Nutritious cat food formulated to meet the dietary needs of your feline friend.",
                        price = 8.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Cat%20Food/1.png",
                        rating = 4.2
                    ),
                    ProductEntity(
                        id = 21,
                        title = "Cucumber",
                        description = "Crisp and hydrating cucumbers, ideal for salads, snacks, or as a refreshing side.",
                        price = 1.49,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Cucumber/1.png",
                        rating = 4.3
                    ),
                    ProductEntity(
                        id = 29,
                        title = "Juice",
                        description = "Refreshing fruit juice, packed with vitamins and great for staying hydrated.",
                        price = 3.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Juice/1.png",
                        rating = 3.8
                    ),
                    ProductEntity(
                        id = 22,
                        title = "Dog Food",
                        description = "Specially formulated dog food designed to provide essential nutrients for your canine companion.",
                        price = 10.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Dog%20Food/1.png",
                        rating = 4.8
                    ),
                    ProductEntity(
                        id = 34,
                        title = "Nescafe Coffee",
                        description = "Quality coffee from Nescafe, available in various blends for a rich and satisfying cup.",
                        price = 7.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Nescafe%20Coffee/1.png",
                        rating = 4.8
                    ),
                    ProductEntity(
                        id = 27,
                        title = "Honey Jar",
                        description = "Pure and natural honey in a convenient jar, perfect for sweetening beverages or drizzling over food.",
                        price = 6.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Honey%20Jar/1.png",
                        rating = 4.4
                    ),
                    ProductEntity(
                        id = 28,
                        title = "Ice Cream",
                        description = "Creamy and delicious ice cream, available in various flavors for a delightful treat.",
                        price = 5.49,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Ice%20Cream/1.png",
                        rating = 4.9
                    ),
                    ProductEntity(
                        id = 20,
                        title = "Cooking Oil",
                        description = "Versatile cooking oil suitable for frying, sautéing, and various culinary applications.",
                        price = 4.99,
                        imageUrl = "https://cdn.dummyjson.com/products/images/groceries/Cooking%20Oil/1.png",
                        rating = 3.9
                    )
                )

                // Map products to ProductEntity
                productList.map {
                    Log.e("products", "${it}")
                    ProductEntity(
                        id = it.id,
                        title = it.title,
                        description = it.description,
                        price = it.price * 100,
                        imageUrl = it.imageUrl,
                        rating = it.rating
                    )
                }
            }
            emit(NetworkResponseState.Success(productEntities)) // Emit success state
        } catch (e: Exception) {
            emit(NetworkResponseState.Error(e)) // Emit error state
        }
    }

}
