package com.redvelvet.remote

import com.redvelvet.repository.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    val movieApiService: MovieApiService
): RemoteDataSource {

}