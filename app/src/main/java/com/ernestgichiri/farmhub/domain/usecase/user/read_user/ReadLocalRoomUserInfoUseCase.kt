package com.ernestgichiri.farmhub.domain.usecase.user.read_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface ReadLocalRoomUserInfoUseCase {

    suspend fun invoke(
        userEmail: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}
