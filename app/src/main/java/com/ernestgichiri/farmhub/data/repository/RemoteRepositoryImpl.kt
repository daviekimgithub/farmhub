package com.ernestgichiri.farmhub.data.repository

import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import com.ernestgichiri.farmhub.domain.repository.RemoteRepository
import com.ernestgichiri.farmhub.common.NetworkResponseState
import com.ernestgichiri.farmhub.data.dto.Category
import com.ernestgichiri.farmhub.data.dto.Product
import com.ernestgichiri.farmhub.data.source.remote.RemoteDataSource
import com.ernestgichiri.farmhub.di.coroutine.IoDispatcher
import com.mustafaunlu.ecommerce_compose.domain.entity.category.CategoryEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val allProductsMapper: ProductListMapper<Product, ProductEntity>,
    private val singleProductMapper: ProductBaseMapper<Product, DetailProductEntity>,
    private val allCategoryMapper: ProductListMapper<Category, String>,
) : RemoteRepository {
    override fun getProductsListFromApi(): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListFromApi().map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>> {
        return remoteDataSource.getSingleProductByIdFromApi(productId).map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(singleProductMapper.map(it.result))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListBySearchFromApi(query).map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>> {
        return remoteDataSource.getAllCategoriesListFromApi().map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allCategoryMapper.map(it.result))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListByCategoryNameFromApi(categoryName).map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }
}
