package com.ernestgichiri.farmhub.data.repository

import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.data.source.local.LocalDataSource
import com.ernestgichiri.farmhub.di.coroutine.IoDispatcher
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val localDataSource: LocalDataSource,
) : LocalRepository {
    override suspend fun getCartsByUserIdFromDb(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> {
        return flow {
            emit(NetworkResponseState.Success(localDataSource.getUserCartByUserIdFromDb(userId)))
        }.flowOn(ioDispatcher)
    }

    override suspend fun insertUserCartToDb(userCartEntity: UserCartEntity) {
        withContext(ioDispatcher) {
            localDataSource.insertUserCartToDb(userCartEntity)
        }
    }

    override suspend fun deleteUserCart(userCartEntity: UserCartEntity) {
        withContext(ioDispatcher) {
            localDataSource.deleteUserCartFromDb(userCartEntity)
        }
    }

    override suspend fun updateUserCart(userCartEntity: UserCartEntity) {
        withContext(ioDispatcher) {
            localDataSource.updateUserCartFromDb(userCartEntity)
        }
    }

    override suspend fun getFavoriteProductsFromDb(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> {
        return flow {
            emit(NetworkResponseState.Success(localDataSource.getFavoriteProductsFromDb(userId)))
        }.flowOn(ioDispatcher)
    }

    override suspend fun insertFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity) {
        withContext(ioDispatcher) {
            localDataSource.insertFavoriteItemToDb(favoriteProductEntity)
        }
    }

    override suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity) {
        withContext(ioDispatcher) {
            localDataSource.deleteFavoriteItemFromDb(favoriteProductEntity)
        }
    }

    override suspend fun getBadgeCountFromDb(userId: String): Flow<NetworkResponseState<Int>> {
        return flow {
            emit(NetworkResponseState.Success(localDataSource.getBadgeCountFromDb(userId)))
        }.flowOn(ioDispatcher)
    }
}
