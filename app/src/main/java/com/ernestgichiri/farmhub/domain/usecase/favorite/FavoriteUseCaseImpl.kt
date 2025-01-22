package com.ernestgichiri.farmhub.domain.usecase.favorite

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : FavoriteUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> =
        repository.getFavoriteProductsFromDb(userId)

    override suspend fun invoke(item: FavoriteProductEntity) {
        repository.insertFavoriteProductToDb(item)
    }
}
