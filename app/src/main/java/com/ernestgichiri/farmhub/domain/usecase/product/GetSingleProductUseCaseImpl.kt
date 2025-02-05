package com.ernestgichiri.farmhub.domain.usecase.product

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import com.ernestgichiri.farmhub.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleProductUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : GetSingleProductUseCase {
    override suspend fun invoke(id: Int): Flow<NetworkResponseState<ProductEntity>> =
        repository.getProductsListFromLocalJsonById(id)
}
