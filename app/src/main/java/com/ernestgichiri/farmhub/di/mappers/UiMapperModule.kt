package com.ernestgichiri.farmhub.di.mappers

import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import com.ernestgichiri.farmhub.ui.mapper.CartEntityToFavoriteEntityMapper
import com.ernestgichiri.farmhub.ui.mapper.CartEntityToUiMapper
import com.ernestgichiri.farmhub.ui.mapper.CartUiToEntityMapper
import com.ernestgichiri.farmhub.ui.mapper.DetailProductEntityToUiMapper
import com.ernestgichiri.farmhub.ui.mapper.FavoriteEntityToUiMapper
import com.ernestgichiri.farmhub.ui.mapper.FavoriteUiToEntityMapper
import com.ernestgichiri.farmhub.ui.mapper.ProductEntityToUiMapper
import com.ernestgichiri.farmhub.ui.mapper.UserInfoEntityToUiDataMapper
import com.ernestgichiri.farmhub.ui.mapper.UserInfoUiDataToEntityMapper
import com.ernestgichiri.farmhub.ui.uiData.DetailProductUiData
import com.ernestgichiri.farmhub.ui.uiData.FavoriteUiData
import com.ernestgichiri.farmhub.ui.uiData.ProductUiData
import com.ernestgichiri.farmhub.ui.uiData.UserCartUiData
import com.ernestgichiri.farmhub.ui.uiData.UserInformationUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeProductUiMapper(productUiDataMapper: ProductEntityToUiMapper): ProductListMapper<ProductEntity, ProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailProductUiMapper(productUiDataMapper: DetailProductEntityToUiMapper): ProductBaseMapper<DetailProductEntity, DetailProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartUiMapper(cartUiDataMapper: CartEntityToUiMapper): ProductListMapper<UserCartEntity, UserCartUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartUiMapper(singleCartUiDataMapper: CartUiToEntityMapper): ProductBaseMapper<UserCartUiData, UserCartEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoEntityToUiDataMapper(userInformationUiDataMapper: UserInfoEntityToUiDataMapper): ProductBaseMapper<UserInformationEntity, UserInformationUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoUiDataToEntityMapper(userInformationEntityMapperToUi: UserInfoUiDataToEntityMapper): ProductBaseMapper<UserInformationUiData, UserInformationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteItemUiMapper(favoriteEntityToUiMapper: FavoriteEntityToUiMapper): ProductListMapper<FavoriteProductEntity, FavoriteUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleFavoriteItemUiMapper(favoriteUiToEntityMapper: FavoriteUiToEntityMapper): ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartToFavoriteEntityMapper(cartEntityToFavoriteEntityMapper: CartEntityToFavoriteEntityMapper): ProductBaseMapper<UserCartEntity, FavoriteProductEntity>
}
