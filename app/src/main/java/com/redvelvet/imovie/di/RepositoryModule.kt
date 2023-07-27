package com.redvelvet.imovie.di

import com.redvelvet.repository.MovieRepositoryImp
import com.redvelvet.usecase.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImp: MovieRepositoryImp
    ): MovieRepository
}