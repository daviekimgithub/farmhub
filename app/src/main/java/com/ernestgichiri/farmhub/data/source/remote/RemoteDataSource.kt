package com.ernestgichiri.farmhub.data.source.remote

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.data.dto.Product
import com.ernestgichiri.farmhub.data.dto.Products
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getProductsListFromApi(): Flow<NetworkResponseState<Products>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>>
}
