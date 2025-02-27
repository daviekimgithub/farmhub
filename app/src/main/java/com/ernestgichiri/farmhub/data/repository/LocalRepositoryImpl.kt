package com.ernestgichiri.farmhub.data.repository

import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.common.TokenManager
import com.ernestgichiri.farmhub.data.json.JsonDataLoader
import com.ernestgichiri.farmhub.data.source.local.LocalDataSource
import com.ernestgichiri.farmhub.di.coroutine.IoDispatcher
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val localDataSource: LocalDataSource,
    private val tokenManager: TokenManager,
) : LocalRepository {
    override suspend fun getCartsByUserIdFromDb(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> {
        return flow {
            emit(NetworkResponseState.Success(localDataSource.getUserCartByUserIdFromDb(userId)))
        }.flowOn(ioDispatcher)
    }

    override suspend fun getProductsListFromLocalJson(): Flow<NetworkResponseState<List<ProductEntity>>> {
        val jsonDataLoader = JsonDataLoader()
        return jsonDataLoader.loadProductEntities()
    }

    override suspend fun getProductsListFromLocalJsonById(productId: Int): Flow<NetworkResponseState<ProductEntity>> {
        val jsonDataLoader = JsonDataLoader()
        return jsonDataLoader.loadProductEntityById(productId)
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

    override suspend fun signUp(user: UserInformationEntity, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        localDataSource.signUpWithRoom(user, onSuccess, onFailure)
    }

    override suspend fun signIn(userEmail: String, password: String, onSuccess: (UserInformationEntity) -> Unit, onFailure: (String) -> Unit) {
        localDataSource.signInWithRoom(userEmail, password, { user ->
            tokenManager.saveToken(user.token)
            onSuccess(user)
        }, onFailure)
    }

    override suspend fun forgotPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        localDataSource.forgotPassword(email, onSuccess, onFailure)
    }

    override suspend fun writeNewUser(user: UserInformationEntity, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        localDataSource.writeUserDataToRoom(user, onSuccess, onFailure)
    }

    override suspend fun readUser(userEmail: String, onSuccess: (UserInformationEntity) -> Unit, onFailure: (String) -> Unit) {
        localDataSource.readUserDataFromRoom(userEmail, onSuccess, onFailure)
    }
}
