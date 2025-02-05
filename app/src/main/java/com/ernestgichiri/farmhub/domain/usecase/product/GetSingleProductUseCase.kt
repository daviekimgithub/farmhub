package com.ernestgichiri.farmhub.domain.usecase.product

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleProductUseCase {
    suspend operator fun invoke(id: Int): Flow<NetworkResponseState<ProductEntity>>
}
