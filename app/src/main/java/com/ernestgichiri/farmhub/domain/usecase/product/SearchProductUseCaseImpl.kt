package com.ernestgichiri.farmhub.domain.usecase.product

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : SearchProductUseCase {
    override fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListBySearchFromApi(query)
    }
}
