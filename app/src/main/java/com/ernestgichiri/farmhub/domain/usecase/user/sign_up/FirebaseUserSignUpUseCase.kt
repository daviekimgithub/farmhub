package com.ernestgichiri.farmhub.domain.usecase.user.sign_up

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface FirebaseUserSignUpUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
