package com.ernestgichiri.farmhub.domain.usecase.cart

import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity

interface DeleteUserCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
