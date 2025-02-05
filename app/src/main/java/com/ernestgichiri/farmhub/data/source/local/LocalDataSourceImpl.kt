package com.ernestgichiri.farmhub.data.source.local

import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.data.database.AppDao
import com.ernestgichiri.farmhub.data.mapper.toUserEntity
import com.ernestgichiri.farmhub.data.mapper.toUserInformationEntity
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val appDao: AppDao) : LocalDataSource {
    override suspend fun getUserCartByUserIdFromDb(userId: String): List<UserCartEntity> {
        return appDao.getCartByUserId(userId)
    }

    override suspend fun insertUserCartToDb(userCartEntity: UserCartEntity) {
        appDao.insertUserCart(userCartEntity)
    }

    override suspend fun deleteUserCartFromDb(userCartEntity: UserCartEntity) {
        appDao.deleteUserCartItem(userCartEntity)
    }

    override suspend fun updateUserCartFromDb(userCartEntity: UserCartEntity) {
        appDao.updateUserCartItem(userCartEntity)
    }

    override suspend fun getFavoriteProductsFromDb(userId: String): List<FavoriteProductEntity> {
        return appDao.getFavoriteProducts(userId)
    }

    override suspend fun insertFavoriteItemToDb(favoriteProductEntity: FavoriteProductEntity) {
        appDao.insertFavoriteItem(favoriteProductEntity)
    }

    override suspend fun deleteFavoriteItemFromDb(favoriteProductEntity: FavoriteProductEntity) {
        appDao.deleteFavoriteItem(favoriteProductEntity)
    }

    override suspend fun getBadgeCountFromDb(userId: String): Int {
        return appDao.getBadgeCount(userId)
    }

    override suspend fun signUpWithRoom(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        try {
            val existingUser = appDao.getUserByEmail(user.email)
            if (existingUser != null) {
                onFailure("User already exists")
                return
            }
            appDao.insertUser(user.toUserEntity())
            onSuccess()
        } catch (e: Exception) {
            onFailure(e.message ?: "An error occurred")
        }
    }

    override suspend fun signInWithRoom(
        email: String,
        password: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        try {
            val userEntity = appDao.getUserByEmail(email)
            if (userEntity == null || userEntity.password != password) {
                onFailure("Invalid email or password")
            } else {
                onSuccess(userEntity.toUserInformationEntity())
            }
        } catch (e: Exception) {
            onFailure(e.message ?: "An error occurred")
        }
    }

    override suspend fun forgotPassword(
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        try {
            val userEntity = appDao.getUserByEmail(email)
            if (userEntity == null) {
                onFailure("Email not found")
            } else {
                onSuccess()
            }
        } catch (e: Exception) {
            onFailure(e.message ?: "An error occurred")
        }
    }

    override suspend fun writeUserDataToRoom(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        try {
            appDao.insertUser(user.toUserEntity())
            onSuccess()
        } catch (e: Exception) {
            onFailure(e.message ?: "An error occurred")
        }
    }

    override suspend fun readUserDataFromRoom(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        try {
            val userEntity = appDao.getUserById(userId)
            if (userEntity != null) {
                onSuccess(userEntity.toUserInformationEntity())
            } else {
                onFailure("User not found")
            }
        } catch (e: Exception) {
            onFailure(e.message ?: "An error occurred")
        }
    }
}
