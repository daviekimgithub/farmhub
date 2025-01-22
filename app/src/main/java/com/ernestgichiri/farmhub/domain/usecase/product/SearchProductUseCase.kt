package com.ernestgichiri.farmhub.domain.usecase.product

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface SearchProductUseCase {
    operator fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
