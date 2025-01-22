package com.ernestgichiri.farmhub.domain.usecase.favorite

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> // getFavoriteProductsFromLocal

    suspend operator fun invoke(item: FavoriteProductEntity) // insertFavoriteItemToDb
}
