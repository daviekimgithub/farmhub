package com.ernestgichiri.farmhub.domain.usecase.user.forget_pw

interface ForgotPwLocalRoomUserUseCase {

    suspend fun invoke(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
}
