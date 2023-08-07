package com.redvelvet.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.repository.pagingSource.MoviesSearchPageSource
import com.redvelvet.repository.pagingSource.MultiSearchPageSource
import com.redvelvet.repository.pagingSource.PeopleSearchPageSource
import com.redvelvet.repository.pagingSource.SeriesSearchPageSource
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource,
) : MovieRepository, BaseRepository() {

    //region search
    override fun multiSearch(query: String, page: Int?): Flow<PagingData<SearchResult>> {
        return Pager(
            config = PagingConfig(pageSize = page ?: 10),
            pagingSourceFactory = { MultiSearchPageSource(remoteDataSource, query) }
        ).flow
    }


    override fun searchPeople(query: String, page: Int?): Flow<PagingData<People>> {
        return Pager(
            config = PagingConfig(pageSize = page ?: 10),
            pagingSourceFactory = { PeopleSearchPageSource(remoteDataSource, query) }
        ).flow
    }

    override fun searchMovie(query: String, page: Int?): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = page ?: 10),
            pagingSourceFactory = { MoviesSearchPageSource(remoteDataSource, query) }
        ).flow
    }

    override fun searchTvShows(query: String, page: Int?): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = page ?: 10),
            pagingSourceFactory = { SeriesSearchPageSource(remoteDataSource, query) }
        ).flow
    }

    // endregion
}