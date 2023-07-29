package com.redvelvet.remote.source

import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
   private val movieApiService: MovieApiService
): RemoteDataSource {


}