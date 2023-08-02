package com.redvelvet.repository.repository

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.repository.mapper.toDomain
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository, BaseRepository() {

    //region Movie Details
    override suspend fun getMovieDetailsById(movieId: Int): MovieDetails {
        return remoteDataSource.getMovieDetailsById(movieId).toDomain()
    }

    override suspend fun getMovieImagesByID(movieId: Int): MovieImages {
        return remoteDataSource.getMovieImagesByID(movieId).toDomain()
    }

    override suspend fun getMovieKeyWordsByID(movieId: Int): MovieKeyWords {
        return remoteDataSource.getMovieKeyWordsByID(movieId).toDomain()
    }

    override suspend fun getMovieRecommendationsByID(movieId: Int): MovieRecommendations {
        return remoteDataSource.getMovieRecommendationsByID(movieId).toDomain()
    }

    override suspend fun getMovieReviewsByID(movieId: Int): MovieReviews {
        return remoteDataSource.getMovieReviewsByID(movieId).toDomain()
    }

    override suspend fun getMovieSimilarByID(movieId: Int): MovieSimilar {
        return remoteDataSource.getMovieSimilarByID(movieId).toDomain()
    }

    override suspend fun getMovieTopCastByID(movieId: Int): MovieTopCast {
        return remoteDataSource.getMovieTopCastByID(movieId).toDomain()
    }
    //endregion

}
