package com.ernestgichiri.farmhub.domain.usecase.user.sign_up

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class LocalRoomUserSignUpUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : LocalRoomUserSignUpUseCase {
    override suspend fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        localRepository.signUp(user, onSuccess, onFailure)
    }
}
