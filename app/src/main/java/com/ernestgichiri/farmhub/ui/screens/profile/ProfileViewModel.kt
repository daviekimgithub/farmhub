package com.ernestgichiri.farmhub.ui.screens.profile

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
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.usecase.user.read_user.ReadLocalRoomUserInfoUseCase
import com.ernestgichiri.farmhub.ui.uiData.UserInformationUiData
import com.ernestgichiri.farmhub.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val readLocalRoomUserInfoUseCase: ReadLocalRoomUserInfoUseCase,  // ✅ Use Local DB instead of Firebase
    private val sharedPreferences: SharedPreferences,
    private val userInfoToUiData: ProductBaseMapper<UserInformationEntity, UserInformationUiData>,
) : ViewModel() {

    private val _userInfos = MutableLiveData<ScreenState<UserInformationUiData>>()
    val userInfos: LiveData<ScreenState<UserInformationUiData>> get() = _userInfos

    init {
        getUserInfosFromLocalDatabase()
    }

    private fun getUserInfosFromLocalDatabase() {
        _userInfos.value = ScreenState.Loading
        val user = getUserFromSharedPref(sharedPreferences)
        if (user != null){
            _userInfos.postValue(ScreenState.Success(userInfoToUiData.map(user)))
        } else {
            _userInfos.postValue(ScreenState.Error("Failed to get user from DB"))
        }
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
