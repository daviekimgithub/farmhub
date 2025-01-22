package com.ernestgichiri.farmhub.ui.screens.favorite

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import com.ernestgichiri.farmhub.domain.usecase.favorite.DeleteFavoriteUseCase
import com.ernestgichiri.farmhub.domain.usecase.favorite.FavoriteUseCase
import com.ernestgichiri.farmhub.ui.uiData.FavoriteUiData
import com.ernestgichiri.farmhub.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase,
    private val mapper: ProductListMapper<FavoriteProductEntity, FavoriteUiData>,
    private val singleMapper: ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    private val _favoriteCarts = MutableLiveData<ScreenState<List<FavoriteUiData>>>()
    val favoriteCarts: LiveData<ScreenState<List<FavoriteUiData>>> get() = _favoriteCarts

    init {
        getFavoriteProducts()
    }

    private fun getFavoriteProducts() {
        viewModelScope.launch {
            favoriteUseCase.invoke(getUserIdFromSharedPref(sharedPreferences)).collect {
                when (it) {
                    is NetworkResponseState.Error -> _favoriteCarts.postValue(
                        ScreenState.Error(
                            it.exception.message!!,
                        ),
                    )

                    is NetworkResponseState.Loading -> _favoriteCarts.postValue(ScreenState.Loading)
                    is NetworkResponseState.Success -> _favoriteCarts.postValue(
                        ScreenState.Success(
                            mapper.map(it.result),
                        ),
                    )
                }
            }
        }
    }

    fun deleteFavoriteItem(favoriteUiData: FavoriteUiData) {
        viewModelScope.launch {
            deleteFavoriteUseCase(singleMapper.map(favoriteUiData))
            getFavoriteProducts()
        }
    }
}
