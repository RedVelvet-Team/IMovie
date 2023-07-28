package com.redvelvet.remote

import com.redvelvet.repository.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
   private val movieApiService: MovieApiService
): RemoteDataSource {

}