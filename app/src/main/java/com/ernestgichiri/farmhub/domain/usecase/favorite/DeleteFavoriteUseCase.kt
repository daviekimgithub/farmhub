package com.ernestgichiri.farmhub.domain.usecase.favorite

import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity

interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}