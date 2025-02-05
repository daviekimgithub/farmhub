package com.ernestgichiri.farmhub.domain.usecase.user.sign_in

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import javax.inject.Inject

class LocalRoomUserSignInUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : LocalRoomUserSignInUseCase {
    override suspend fun invoke(
        userEmail: String,
        password: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        localRepository.signIn(userEmail, password, onSuccess, onFailure)
    }
}
