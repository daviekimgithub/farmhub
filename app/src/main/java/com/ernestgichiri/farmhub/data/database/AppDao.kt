package com.ernestgichiri.farmhub.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ernestgichiri.farmhub.data.dto.UserEntity
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserCart(userCartEntity: UserCartEntity)

    @Query("SELECT * FROM user_carts WHERE userId = :userId")
    suspend fun getCartByUserId(userId: String): List<UserCartEntity>

    @Delete
    suspend fun deleteUserCartItem(userCartEntity: UserCartEntity)

    @Update
    suspend fun updateUserCartItem(userCartEntity: UserCartEntity)

    @Query("SELECT * FROM favorite_items WHERE userId = :userId")
    suspend fun getFavoriteProducts(userId: String): List<FavoriteProductEntity>

    @Insert(FavoriteProductEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteItem(favoriteProductEntity: FavoriteProductEntity)

    @Delete(FavoriteProductEntity::class)
    suspend fun deleteFavoriteItem(favoriteProductEntity: FavoriteProductEntity)

    @Query("SELECT COUNT(*) FROM user_carts WHERE userId = :userId")
    suspend fun getBadgeCount(userId: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE id = :email")
    suspend fun getUserByEmail(email: String): UserEntity?

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: String): UserEntity?
}
