package com.ernestgichiri.farmhub.domain.usecase.cart.badge

import com.ernestgichiri.farmhub.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface UserCartBadgeUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<Int>>
}