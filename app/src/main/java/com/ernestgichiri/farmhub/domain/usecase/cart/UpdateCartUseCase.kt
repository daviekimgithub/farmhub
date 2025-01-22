package com.ernestgichiri.farmhub.domain.usecase.cart // ktlint-disable package-name

import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity

interface UpdateCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
