package com.ernestgichiri.farmhub.ui.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import com.ernestgichiri.farmhub.domain.usecase.category.CategoryUseCase
import com.ernestgichiri.farmhub.domain.usecase.product.GetAllProductsUseCase
import com.ernestgichiri.farmhub.domain.usecase.product.SearchProductUseCase
import com.ernestgichiri.farmhub.ui.uiData.ProductUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val mapper: ProductListMapper<ProductEntity, ProductUiData>,
) :
    ViewModel() {
    private val _products = MutableLiveData<ScreenState<List<ProductUiData>>>()
    val products: LiveData<ScreenState<List<ProductUiData>>> get() = _products

    private val _categories = MutableLiveData<ScreenState<List<String>>>()
    val categories: LiveData<ScreenState<List<String>>> get() = _categories

    init {
        runBlocking {
            getAllProducts()
        }
    }

    private suspend fun getAllProducts() {
        getAllProductsUseCase().onEach {
            when (it) {
                is NetworkResponseState.Error -> {
                    _products.postValue(ScreenState.Error(it.exception.message!!))
                    Log.e("data", it.exception.toString())
                    Log.e("data", it.exception.message.toString())
                }
                is NetworkResponseState.Loading -> _products.postValue(ScreenState.Loading)
                is NetworkResponseState.Success -> {
                    _products.postValue(ScreenState.Success(mapper.map(it.result)))
                    Log.e("data", it.result.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}
