package com.ernestgichiri.farmhub.ui.screens.auth.viewModels

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestgichiri.farmhub.common.Constants.PREF_FIREBASE_USERID_KEY
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.usecase.user.sign_in.LocalRoomUserSignInUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigInViewModel @Inject constructor(
    private val localRoomUserSignInUseCase: LocalRoomUserSignInUseCaseImpl,  // Only Local Room Sign-In
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {

    private val _userData = MutableLiveData<ScreenState<UserInformationEntity>>()
    val userData: LiveData<ScreenState<UserInformationEntity>> get() = _userData

    /** Login via Local Room Database */
    fun loginWithLocalRoom(userEmail: String, password: String) {
        viewModelScope.launch {
            _userData.postValue(ScreenState.Loading)
            localRoomUserSignInUseCase.invoke(
                userEmail, password,
                onSuccess = { userInfo ->
                    _userData.postValue(ScreenState.Success(userInfo))
                    saveUserIdToSharedPref(userInfo.id)
                },
                onFailure = { errorMsg ->
                    _userData.postValue(ScreenState.Error(errorMsg))
                }
            )
        }
    }

    /** Save authenticated user ID to SharedPreferences */
    private fun saveUserIdToSharedPref(id: String) {
        sharedPreferences.edit()
            .putString(PREF_FIREBASE_USERID_KEY, id)
            .apply()
    }
}
