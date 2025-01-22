package com.ernestgichiri.farmhub.domain.usecase.user.read_user

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.FirebaseRepository
import javax.inject.Inject

class ReadFirebaseUserInfosUseCaseImpl @Inject constructor(
    private val repository: FirebaseRepository
): ReadFirebaseUserInfosUseCase {
    override fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        repository.readUserFromFirebaseDatabase(userId, onSuccess, onFailure)
    }
}