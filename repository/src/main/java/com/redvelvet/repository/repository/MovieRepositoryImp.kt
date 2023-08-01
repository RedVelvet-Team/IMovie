package com.redvelvet.repository.repository

import com.redvelvet.repository.mapper.toErrorType
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.util.RemoteError
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository {


    private fun <T> wrapRemoteRequest(function: suspend () -> T): suspend () -> T {
        try {
            return function
        }catch (e: RemoteError){
            throw e.toErrorType()
        }
    }
}
