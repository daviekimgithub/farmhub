package com.ernestgichiri.farmhub.ui.screens.profile

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import com.ernestgichiri.farmhub.ui.uiData.UserInformationUiData
import com.ernestgichiri.farmhub.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val readFirebaseUserInfosUseCase: ReadFirebaseUserInfosUseCase,
    private val sharedPreferences: SharedPreferences,
    private val firebaseUserInfoToUiData: ProductBaseMapper<UserInformationEntity, UserInformationUiData>,
) : ViewModel() {
    private val _userInfos = MutableLiveData<ScreenState<UserInformationUiData>>()
    val userInfos: LiveData<ScreenState<UserInformationUiData>> get() = _userInfos

    init {
        getUserInfosFromFirebase()
    }

    private fun getUserInfosFromFirebase() {
        _userInfos.value = ScreenState.Loading
        viewModelScope.launch {
            readFirebaseUserInfosUseCase.invoke(
                getUserIdFromSharedPref(sharedPreferences),
                onSuccess = {
                    _userInfos.postValue(ScreenState.Success(firebaseUserInfoToUiData.map(it)))
                },
            ) {
                _userInfos.postValue(ScreenState.Error(it))
            }
        }
    }
}
