package com.ernestgichiri.farmhub.domain.usecase.user.write_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.FirebaseRepository
import javax.inject.Inject

class WriteFirebaseUserInfosCaseImpl @Inject constructor(
    private val repository: FirebaseRepository,
) : WriteFirebaseUserInfosUseCase {
    override fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        repository.writeNewUserToFirebaseDatabase(user, onSuccess, onFailure)
    }
}
