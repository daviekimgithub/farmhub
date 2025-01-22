package com.ernestgichiri.farmhub.di.mappers

import com.ernestgichiri.farmhub.data.dto.Category
import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import com.ernestgichiri.farmhub.data.dto.Product
import com.ernestgichiri.farmhub.data.mapper.CategoryEntityMapper
import com.ernestgichiri.farmhub.data.mapper.ProductEntityMapper
import com.ernestgichiri.farmhub.data.mapper.SingleProductEntityMapper
import com.mustafaunlu.ecommerce_compose.domain.entity.category.CategoryEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAllProductsEntityMapper(productEntityMapper: ProductEntityMapper): ProductListMapper<Product, ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindAllCategoriesEntityMapper(productEntityMapper: CategoryEntityMapper): ProductListMapper<Category, CategoryEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleProductEntityMapper(singleProductEntityMapper: SingleProductEntityMapper): ProductBaseMapper<Product, DetailProductEntity>
}
