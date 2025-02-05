package com.ernestgichiri.farmhub.domain.usecase.user.write_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface WriteLocalRoomUserInfoUseCase {
    suspend fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )
}
