package com.ernestgichiri.farmhub.ui.screens.auth.viewModels // ktlint-disable package-name

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestgichiri.farmhub.common.Constants.EMAIL
import com.ernestgichiri.farmhub.common.Constants.NAME
import com.ernestgichiri.farmhub.common.Constants.PASSWORD
import com.ernestgichiri.farmhub.common.Constants.PHONE
import com.ernestgichiri.farmhub.common.Constants.PREF_USERID_KEY
import com.ernestgichiri.farmhub.common.Constants.SURNAME
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.write_user.WriteFirebaseUserInfosUseCase
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.usecase.user.write_user.WriteLocalRoomUserInfoUseCase
import com.ernestgichiri.farmhub.ui.uiData.UserInformationUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val writeLocalRoomUserInfoUseCase: WriteLocalRoomUserInfoUseCase,
    private val userInfoToEntity: ProductBaseMapper<UserInformationUiData, UserInformationEntity>,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    private val _signUp = MutableLiveData<ScreenState<UserInformationUiData>>()
    val signUp: LiveData<ScreenState<UserInformationUiData>> get() = _signUp

    fun signUp(user: UserInformationUiData) {
        _signUp.value = ScreenState.Loading
        saveUserIdToSharedPref(user)
        _signUp.postValue(ScreenState.Success(user))
//        viewModelScope.launch {
//            writeLocalRoomUserInfoUseCase.invoke(
//                userInfoToEntity.map(user),
//                onSuccess = {
//                    _signUp.postValue(ScreenState.Success(user))
//                    writeUserToFirebaseDatabase(userInfoToEntity.map(user))
//                },
//            ) {
//                _signUp.postValue(ScreenState.Error(it))
//            }
//        }
    }

    private fun writeUserToFirebaseDatabase(user: UserInformationEntity) {
        viewModelScope.launch {
            writeLocalRoomUserInfoUseCase.invoke(
                user,
                onSuccess = {},
            ) {
                _signUp.postValue(ScreenState.Error(it))
            }
        }
    }

    private fun saveUserIdToSharedPref(user: UserInformationUiData) {
        sharedPreferences.edit()
            .putString(PREF_USERID_KEY, user.id)
            .apply()
        sharedPreferences.edit()
            .putString(EMAIL, user.email)
            .apply()
        sharedPreferences.edit()
            .putString(NAME, user.name)
            .apply()
        sharedPreferences.edit()
            .putString(PASSWORD, user.password)
            .apply()
        sharedPreferences.edit()
            .putString(PHONE, user.phone)
            .apply()
        sharedPreferences.edit()
            .putString(SURNAME, user.surname)
            .apply()
    }
}
