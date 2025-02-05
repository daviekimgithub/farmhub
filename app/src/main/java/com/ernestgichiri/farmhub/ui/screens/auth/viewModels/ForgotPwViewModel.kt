package com.ernestgichiri.farmhub.ui.screens.auth.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.usecase.user.forget_pw.ForgotPwLocalRoomUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPwViewModel @Inject constructor(
    private val forgotPwUseCase: ForgotPwLocalRoomUserUseCase,  // Renamed for clarity
) : ViewModel() {

    private val _forgotPassword = MutableLiveData<ScreenState<String>>()
    val forgotPassword: LiveData<ScreenState<String>> get() = _forgotPassword

    fun forgotPassword(email: String) {
        viewModelScope.launch {
            _forgotPassword.postValue(ScreenState.Loading)
            forgotPwUseCase.invoke(
                email,
                onSuccess = {
                    _forgotPassword.postValue(ScreenState.Success("Password reset successful"))
                },
                onFailure = { error ->
                    _forgotPassword.postValue(ScreenState.Error(error))
                }
            )
        }
    }
}