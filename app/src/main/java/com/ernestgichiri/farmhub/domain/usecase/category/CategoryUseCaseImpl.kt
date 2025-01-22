package com.ernestgichiri.farmhub.domain.usecase.category

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(private val repository: RemoteRepository) :
    CategoryUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<String>>> {
        return repository.getAllCategoriesListFromApi()
    }
}
