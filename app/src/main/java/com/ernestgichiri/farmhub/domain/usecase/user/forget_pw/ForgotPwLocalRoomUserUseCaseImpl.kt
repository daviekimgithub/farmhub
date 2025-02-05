package com.ernestgichiri.farmhub.domain.usecase.user.forget_pw

import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class ForgotPwLocalRoomUserUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : ForgotPwLocalRoomUserUseCase {
    override suspend fun invoke(
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        localRepository.forgotPassword(email, onSuccess, onFailure)
    }
}
