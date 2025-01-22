package com.ernestgichiri.farmhub.domain.usecase.category

import com.ernestgichiri.farmhub.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<String>>>
}
