package com.redvelvet.imovie.di

import com.redvelvet.firebase.FirebaseDataSourceImp
import com.redvelvet.local.LocalDataSourceImp
import com.redvelvet.remote.RemoteDataSourceImp
import com.redvelvet.repository.FirebaseDataSource
import com.redvelvet.repository.LocalDataSource
import com.redvelvet.repository.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDataSource(
        localDataSourceImp: LocalDataSourceImp
    ): LocalDataSource

    @Binds
    abstract fun bindFirebaseDataSource(
        firebaseDataSourceImp: FirebaseDataSourceImp
    ): FirebaseDataSource

    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSourceImp: RemoteDataSourceImp
    ): RemoteDataSource
}