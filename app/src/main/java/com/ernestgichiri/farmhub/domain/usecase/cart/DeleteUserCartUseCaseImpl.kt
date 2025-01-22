package com.ernestgichiri.farmhub.domain.usecase.cart

import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteUserCartUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    DeleteUserCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.deleteUserCart(userCartEntity)
    }
}
