package com.redvelvet.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.redvelvet.entities.actor.Actor
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.repository.pagingSource.ActorSearchPageSource
import com.redvelvet.repository.pagingSource.MoviesSearchPageSource
import com.redvelvet.repository.pagingSource.MultiSearchPageSource
import com.redvelvet.repository.pagingSource.TvShowSearchPageSource
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository, BaseRepository() {

    //region search
    private fun <T : Any> search(
        query: String,
        page: Int?,
        sourceFactory: (RemoteDataSource, String) -> PagingSource<Int, T>
    ): Flow<PagingData<T>> {
        return Pager(
            config = PagingConfig(pageSize = page ?: DEFAULT_PAGE_SIZE),
            pagingSourceFactory = { sourceFactory(remoteDataSource, query) }
        ).flow
    }

    override fun multiSearch(query: String, page: Int?): Flow<PagingData<SearchResult>> {
        return search(query, page, ::MultiSearchPageSource)
    }

    override fun searchPeople(query: String, page: Int?): Flow<PagingData<Actor>> {
        return search(query, page, ::ActorSearchPageSource)
    }

    override fun searchMovie(query: String, page: Int?): Flow<PagingData<Movie>> {
        return search(query, page, ::MoviesSearchPageSource)
    }

    override fun searchTvShows(query: String, page: Int?): Flow<PagingData<TvShow>> {
        return search(query, page, ::TvShowSearchPageSource)
    }

    // endregion
    companion object {
        private const val DEFAULT_PAGE_SIZE = 10
    }
}
