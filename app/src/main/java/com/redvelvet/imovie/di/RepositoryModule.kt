package com.redvelvet.imovie.di

import com.redvelvet.repository.repository.*
import com.redvelvet.usecase.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Singleton
    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Singleton
    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Singleton
    @Binds
    abstract fun bindTvShowRepository(
        tvShowRepositoryImp: TvShowRepositoryImp
    ): TvShowRepository

    @Singleton
    @Binds
    abstract fun bindMediaActionsRepository(
        mediaActionsRepository: MediaActionsRepositoryImpl
    ): MediaActionsRepository

    @Singleton
    @Binds
    abstract fun bindLibraryRepository(
        libraryRepository: LibraryRepositoryImpl
    ): LibraryRepository


    @Singleton
    @Binds
    abstract fun bindLibraryListRepository(
        libraryListRepository: LiberaryListRepositoryImp
    ): LiberaryListsRepository


}