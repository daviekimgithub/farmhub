package com.ernestgichiri.farmhub.domain.repository

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {

    fun getProductsListFromApi(): Flow<NetworkResponseState<List<ProductEntity>>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
