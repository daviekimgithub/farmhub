package com.ernestgichiri.farmhub.domain.usecase.user.sign_in

import com.ernestgichiri.farmhub.domain.entity.user.SignInUserEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

interface FirebaseUserSingInUseCase {
    operator fun invoke(
        user: SignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}