package com.ernestgichiri.farmhub.di.source

import com.ernestgichiri.farmhub.data.source.remote.FirebaseDataSource
import com.ernestgichiri.farmhub.data.source.remote.FirebaseDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class FirebaseDataSourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindDataSource(
        dataSource: FirebaseDataSourceImpl,
    ): FirebaseDataSource
}