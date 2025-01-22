package com.ernestgichiri.farmhub.di.usecase

import com.ernestgichiri.farmhub.domain.usecase.cart.CartUseCase
import com.ernestgichiri.farmhub.domain.usecase.cart.CartUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.cart.DeleteUserCartUseCase
import com.ernestgichiri.farmhub.domain.usecase.cart.DeleteUserCartUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.cart.UpdateCartUseCase
import com.ernestgichiri.farmhub.domain.usecase.cart.UpdateCartUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.cart.badge.UserCartBadgeUseCase
import com.ernestgichiri.farmhub.domain.usecase.cart.badge.UserCartBadgeUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.category.CategoryUseCase
import com.ernestgichiri.farmhub.domain.usecase.category.CategoryUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.favorite.DeleteFavoriteUseCase
import com.ernestgichiri.farmhub.domain.usecase.favorite.DeleteFavoriteUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.favorite.FavoriteUseCase
import com.ernestgichiri.farmhub.domain.usecase.favorite.FavoriteUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.product.GetAllProductsUseCase
import com.ernestgichiri.farmhub.domain.usecase.product.GetAllProductsUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.product.GetSingleProductUseCase
import com.ernestgichiri.farmhub.domain.usecase.product.GetSingleProductUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.product.SearchProductUseCase
import com.ernestgichiri.farmhub.domain.usecase.product.SearchProductUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.sign_in.FirebaseUserSingInUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.sign_in.FirebaseUserSingInUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import com.ernestgichiri.farmhub.domain.usecase.user.sign_up.FirebaseUserSignUpUseCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.write_user.WriteFirebaseUserInfosCaseImpl
import com.ernestgichiri.farmhub.domain.usecase.user.write_user.WriteFirebaseUserInfosUseCase
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
        getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl,
    ): GetAllProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSingleProductUseCase(
        getSingleProductUseCaseImpl: GetSingleProductUseCaseImpl,
    ): GetSingleProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllCategoryUseCase(
        getAllCategoryUseCaseImpl: CategoryUseCaseImpl,
    ): CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCartUseCase(
        cartUseCaseImpl: CartUseCaseImpl,
    ): CartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteUserCartUseCase(
        deleteUserCartUseCaseImpl: DeleteUserCartUseCaseImpl,
    ): DeleteUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSearchUseCase(
        searchUseCaseImpl: SearchProductUseCaseImpl,
    ): SearchProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpdateCartUseCase(
        updateCartUseCaseImpl: UpdateCartUseCaseImpl,
    ): UpdateCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUseCase(
        favoriteUseCaseImpl: FavoriteUseCaseImpl,
    ): FavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteUseCase(
        deleteFavoriteUseCaseImpl: DeleteFavoriteUseCaseImpl,
    ): DeleteFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignUpUseCase(
        firebaseSignUpUseCaseImpl: FirebaseUserSignUpUseCaseImpl,
    ): FirebaseUserSignUpUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignInUseCase(
        firebaseSignInUseCaseImpl: FirebaseUserSingInUseCaseImpl,
    ): FirebaseUserSingInUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseForgetPwUseCase(
        firebaseForgetPwUseCaseImpl: ForgotPwFirebaseUserUseCaseImpl,
    ): ForgotPwFirebaseUserUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseWriteUserUseCase(
        firebaseWriteUserUseCaseImpl: WriteFirebaseUserInfosCaseImpl,
    ): WriteFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseReadUserUseCase(
        firebaseReadUserCaseImpl: ReadFirebaseUserInfosUseCaseImpl,
    ): ReadFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUserCartBadgeUseCase(
        userCartBadgeUseCaseImpl: UserCartBadgeUseCaseImpl,
    ): UserCartBadgeUseCase
}
