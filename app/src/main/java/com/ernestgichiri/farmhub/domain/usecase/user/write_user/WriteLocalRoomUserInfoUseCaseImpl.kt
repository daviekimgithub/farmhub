package com.ernestgichiri.farmhub.domain.usecase.user.write_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class WriteLocalRoomUserInfoUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : WriteLocalRoomUserInfoUseCase {
    override suspend fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        localRepository.writeNewUser(user, onSuccess, onFailure)
    }
}
