package com.ernestgichiri.farmhub.di.repository

import com.ernestgichiri.farmhub.domain.repository.FirebaseRepository
import com.ernestgichiri.farmhub.domain.repository.LocalRepository
import com.ernestgichiri.farmhub.domain.repository.RemoteRepository
import com.ernestgichiri.farmhub.data.repository.FirebaseRepositoryImpl
import com.ernestgichiri.farmhub.data.repository.LocalRepositoryImpl
import com.ernestgichiri.farmhub.data.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteRepository(
        repository: RemoteRepositoryImpl,
    ): RemoteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRepository(
        repository: LocalRepositoryImpl,
    ): LocalRepository

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseRepository(
        repository: FirebaseRepositoryImpl,
    ): FirebaseRepository
}
