package com.ernestgichiri.farmhub.domain.repository

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun getCartsByUserIdFromDb(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>>

    suspend fun getProductsListFromLocalJson(): Flow<NetworkResponseState<List<ProductEntity>>>

    suspend fun insertUserCartToDb(userCartEntity: UserCartEntity)

    suspend fun deleteUserCart(userCartEntity: UserCartEntity)

    suspend fun updateUserCart(userCartEntity: UserCartEntity)

    suspend fun getFavoriteProductsFromDb(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>>

    suspend fun insertFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity)

    suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)

    suspend fun getBadgeCountFromDb(userId: String): Flow<NetworkResponseState<Int>>
}
