package com.redvelvet.imovie.di

import com.redvelvet.datastore.UserDataStoreDataSource
import com.redvelvet.firebase.FirebaseDataSource
import com.redvelvet.local.source.RoomDatabaseDataSource
import com.redvelvet.remote.source.RetrofitDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RealTimeDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.source.UserPreferencesDataSource
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
        roomDatabaseDataSource: RoomDatabaseDataSource
    ): LocalDataSource

    @Singleton
    @Binds
    abstract fun bindFirebaseDataSource(
        firebaseDataSource: FirebaseDataSource
    ): RealTimeDataSource

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        retrofitDataSource: RetrofitDataSource
    ): RemoteDataSource

    @Singleton
    @Binds
    abstract fun bindDataSourceDataSource(
        userDataStoreDataSource: UserDataStoreDataSource
    ): UserPreferencesDataSource
}