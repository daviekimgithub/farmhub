package com.ernestgichiri.farmhub.ui.screens.auth.viewModels

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
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.usecase.user.sign_in.LocalRoomUserSignInUseCaseImpl
import com.ernestgichiri.farmhub.ui.uiData.UserInformationUiData
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
    fun loginWithLocalRoom(userEmail: String, userPassword: String) {
        viewModelScope.launch {
            _userData.postValue(ScreenState.Loading)
            val email = sharedPreferences.getString(EMAIL, null)
            val password = sharedPreferences.getString(PASSWORD, null)
            if(email == userEmail && password == userPassword){
                val loggedInUser = getUserFromSharedPref(sharedPreferences)
                if(loggedInUser != null){
                    _userData.postValue(ScreenState.Success(uiData = loggedInUser))
                }
            }
//            localRoomUserSignInUseCase.invoke(
//                userEmail, password,
//                onSuccess = { userInfo ->
//                    _userData.postValue(ScreenState.Success(userInfo))
//                    saveUserIdToSharedPref(userInfo.id)
//                },
//                onFailure = { errorMsg ->
//                    _userData.postValue(ScreenState.Error(errorMsg))
//                }
//            )
        }
    }

    /** Save authenticated user ID to SharedPreferences */
    private fun saveUserIdToSharedPref(id: String) {
        sharedPreferences.edit()
            .putString(PREF_USERID_KEY, id)
            .apply()
    }

    private fun getUserFromSharedPref(sharedPreferences: SharedPreferences): UserInformationEntity? {
        val id = sharedPreferences.getString(PREF_USERID_KEY, null)
        val email = sharedPreferences.getString(EMAIL, null)
        val name = sharedPreferences.getString(NAME, null)
        val password = sharedPreferences.getString(PASSWORD, null)
        val phone = sharedPreferences.getString(PHONE, null)
        val surname = sharedPreferences.getString(SURNAME, null)

        return if (id != null && email != null && name != null && password != null && phone != null && surname != null) {
            UserInformationEntity(
                id = id,
                name = name,
                password = password,
                phone = phone,
                surname = surname,
                email = email,
                image = "",
                token = ""
            )
        } else {
            null // Return null if any required field is missing
        }
    }

}
