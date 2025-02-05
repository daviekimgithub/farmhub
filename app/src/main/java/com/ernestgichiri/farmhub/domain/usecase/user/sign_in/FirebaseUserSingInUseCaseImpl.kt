package com.ernestgichiri.farmhub.domain.usecase.user.sign_in

import com.ernestgichiri.farmhub.domain.entity.user.SignInUserEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseUserSingInUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
): FirebaseUserSingInUseCase {
    override fun invoke(user: SignInUserEntity, onSuccess: (UserInformationEntity) -> Unit, onFailure: (String) -> Unit) {
        firebaseRepository.signInWithFirebase(user, onSuccess, onFailure)
    }
}