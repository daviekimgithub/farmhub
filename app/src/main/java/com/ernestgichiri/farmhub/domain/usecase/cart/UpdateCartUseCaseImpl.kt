package com.ernestgichiri.farmhub.domain.usecase.cart // ktlint-disable package-name

import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class UpdateCartUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UpdateCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.updateUserCart(userCartEntity)
    }
}
