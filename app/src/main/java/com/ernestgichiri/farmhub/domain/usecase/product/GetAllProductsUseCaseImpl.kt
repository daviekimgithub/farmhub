package com.ernestgichiri.farmhub.domain.usecase.product

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetAllProductsUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>> = repository.getProductsListFromApi()

    override fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListByCategoryNameFromApi(categoryName)
    }
}
