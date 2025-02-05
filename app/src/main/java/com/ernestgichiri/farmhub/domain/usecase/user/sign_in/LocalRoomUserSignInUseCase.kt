package com.ernestgichiri.farmhub.domain.usecase.user.sign_in

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface LocalRoomUserSignInUseCase {
    suspend fun invoke(
        userEmail: String,
        password: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}
