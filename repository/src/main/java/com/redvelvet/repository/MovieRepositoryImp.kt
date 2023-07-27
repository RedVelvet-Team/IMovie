package com.redvelvet.repository

import com.redvelvet.usecase.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
) : MovieRepository {

}