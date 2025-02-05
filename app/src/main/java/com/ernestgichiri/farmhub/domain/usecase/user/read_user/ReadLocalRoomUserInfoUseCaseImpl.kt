package com.ernestgichiri.farmhub.domain.usecase.user.read_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class ReadLocalRoomUserInfoUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : ReadLocalRoomUserInfoUseCase {
    override suspend fun invoke(
        userEmail: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        localRepository.readUser(userEmail, onSuccess, onFailure)
    }
}
