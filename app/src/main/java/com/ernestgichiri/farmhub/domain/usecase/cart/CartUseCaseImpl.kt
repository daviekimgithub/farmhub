package com.ernestgichiri.farmhub.domain.usecase.cart

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCaseImpl @Inject constructor(private val repository: LocalRepository) : CartUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> = repository.getCartsByUserIdFromDb(userId)
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.insertUserCartToDb(userCartEntity)
    }
}
