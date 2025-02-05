package com.ernestgichiri.farmhub.di.usecase

import com.ernestgichiri.farmhub.domain.usecase.cart.*
import com.ernestgichiri.farmhub.domain.usecase.cart.badge.*
import com.ernestgichiri.farmhub.domain.usecase.category.*
import com.ernestgichiri.farmhub.domain.usecase.favorite.*
import com.ernestgichiri.farmhub.domain.usecase.product.*
import com.ernestgichiri.farmhub.domain.usecase.user.forget_pw.ForgotPwLocalRoomUserUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.forget_pw.ForgotPwLocalRoomUserUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.read_user.ReadLocalRoomUserInfoUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.read_user.ReadLocalRoomUserInfoUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.sign_in.LocalRoomUserSignInUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.sign_in.LocalRoomUserSignInUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.sign_up.LocalRoomUserSignUpUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.sign_up.LocalRoomUserSignUpUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.write_user.WriteLocalRoomUserInfoUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.write_user.WriteLocalRoomUserInfoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllProductsUseCase(
        impl: GetAllProductsUseCaseImpl
    ): GetAllProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSingleProductUseCase(
        impl: GetSingleProductUseCaseImpl
    ): GetSingleProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllCategoryUseCase(
        impl: CategoryUseCaseImpl
    ): CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCartUseCase(
        impl: CartUseCaseImpl
    ): CartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteUserCartUseCase(
        impl: DeleteUserCartUseCaseImpl
    ): DeleteUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSearchUseCase(
        impl: SearchProductUseCaseImpl
    ): SearchProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpdateCartUseCase(
        impl: UpdateCartUseCaseImpl
    ): UpdateCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUseCase(
        impl: FavoriteUseCaseImpl
    ): FavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteUseCase(
        impl: DeleteFavoriteUseCaseImpl
    ): DeleteFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRoomSignUpUseCase(
        impl: LocalRoomUserSignUpUseCaseImpl
    ): LocalRoomUserSignUpUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRoomSignInUseCase(
        impl: LocalRoomUserSignInUseCaseImpl
    ): LocalRoomUserSignInUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRoomForgetPwUseCase(
        impl: ForgotPwLocalRoomUserUseCaseImpl
    ): ForgotPwLocalRoomUserUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRoomWriteUserUseCase(
        impl: WriteLocalRoomUserInfoUseCaseImpl
    ): WriteLocalRoomUserInfoUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRoomReadUserUseCase(
        impl: ReadLocalRoomUserInfoUseCaseImpl
    ): ReadLocalRoomUserInfoUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUserCartBadgeUseCase(
        impl: UserCartBadgeUseCaseImpl
    ): UserCartBadgeUseCase
}
