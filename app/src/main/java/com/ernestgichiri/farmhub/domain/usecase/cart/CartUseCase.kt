package com.ernestgichiri.farmhub.domain.usecase.cart

import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> // getCartsByUserIdFromLocal

    suspend operator fun invoke(userCartEntity: UserCartEntity) // insertCartToDb
}
