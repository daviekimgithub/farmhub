package com.ernestgichiri.farmhub.domain.usecase.user.sign_up

import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseUserSignUpUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository,
) : FirebaseUserSignUpUseCase {
    override fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseRepository.signUpWithFirebase(user, onSuccess, onFailure)
    }
}
