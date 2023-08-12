package com.redvelvet.imovie.di

import com.redvelvet.datastore.DataStoreDataSourceImpl
import com.redvelvet.firebase.FirebaseDataSourceImp
import com.redvelvet.local.source.LocalDataSourceImp
import com.redvelvet.remote.source.RemoteDataSourceImp
import com.redvelvet.repository.source.DataStoreDataSource
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindLocalDataSource(
        localDataSourceImp: LocalDataSourceImp
    ): LocalDataSource

    @Singleton
    @Binds
    abstract fun bindFirebaseDataSource(
        firebaseDataSourceImp: FirebaseDataSourceImp
    ): FirebaseDataSource

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSourceImp: RemoteDataSourceImp
    ): RemoteDataSource

    @Singleton
    @Binds
    abstract fun bindDataSourceDataSource(
        dataStoreDataSourceImpl: DataStoreDataSourceImpl
    ): DataStoreDataSource
}