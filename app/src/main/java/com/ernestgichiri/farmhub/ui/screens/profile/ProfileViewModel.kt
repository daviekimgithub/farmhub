package com.ernestgichiri.farmhub.ui.screens.profile

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        val userEmail = getUserIdFromSharedPref(sharedPreferences)  // ✅ Get stored email
        if (userEmail.isNullOrEmpty()) {
            _userInfos.postValue(ScreenState.Error("User email not found"))
            return
        }

        viewModelScope.launch {
            readLocalRoomUserInfoUseCase.invoke(
                userEmail,
                onSuccess = { userInfo ->
                    _userInfos.postValue(ScreenState.Success(userInfoToUiData.map(userInfo)))
                },
                onFailure = { errorMsg ->
                    _userInfos.postValue(ScreenState.Error(errorMsg))
                }
            )
        }
    }
}
