package com.ernestgichiri.farmhub.domain.usecase.favorite

import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteFavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : DeleteFavoriteUseCase {
    override suspend fun invoke(favoriteProductEntity: FavoriteProductEntity) {
        repository.deleteFavoriteProduct(favoriteProductEntity)
    }
}
