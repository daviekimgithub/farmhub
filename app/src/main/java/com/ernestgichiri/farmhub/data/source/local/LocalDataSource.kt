package com.ernestgichiri.farmhub.data.source.local

import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface LocalDataSource {
    suspend fun getUserCartByUserIdFromDb(userId: String): List<UserCartEntity>

    suspend fun insertUserCartToDb(userCartEntity: UserCartEntity)

    suspend fun deleteUserCartFromDb(userCartEntity: UserCartEntity)

    suspend fun updateUserCartFromDb(userCartEntity: UserCartEntity)

    suspend fun getFavoriteProductsFromDb(userId: String): List<FavoriteProductEntity>

    suspend fun insertFavoriteItemToDb(favoriteProductEntity: FavoriteProductEntity)

    suspend fun deleteFavoriteItemFromDb(favoriteProductEntity: FavoriteProductEntity)

    suspend fun getBadgeCountFromDb(userId: String): Int

    suspend fun signUpWithRoom(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    suspend fun signInWithRoom(
        email: String,
        password: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )

    suspend fun forgotPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    suspend fun writeUserDataToRoom(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    suspend fun readUserDataFromRoom(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}
