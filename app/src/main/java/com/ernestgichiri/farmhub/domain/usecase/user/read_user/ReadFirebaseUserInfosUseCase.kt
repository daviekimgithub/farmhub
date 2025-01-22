package com.ernestgichiri.farmhub.domain.usecase.user.read_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface ReadFirebaseUserInfosUseCase {
    operator fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    )
}
