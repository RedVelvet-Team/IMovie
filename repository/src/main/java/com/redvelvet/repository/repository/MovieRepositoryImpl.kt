package com.redvelvet.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.entities.actor.Actor
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.mapper.toActor
import com.redvelvet.repository.mapper.toCombinedResult
import com.redvelvet.repository.mapper.toDomain
import com.redvelvet.repository.mapper.toEpisodeDetails
import com.redvelvet.repository.mapper.toMovie
import com.redvelvet.repository.mapper.toSeasonTvShow
import com.redvelvet.repository.mapper.toTvShow
import com.redvelvet.repository.pagingSource.ActorSearchPageSource
import com.redvelvet.repository.pagingSource.MoviesSearchPageSource
import com.redvelvet.repository.pagingSource.MultiSearchPageSource
import com.redvelvet.repository.pagingSource.TvShowSearchPageSource
import com.redvelvet.repository.pagingSource.seeall.SeeAllNowPlayingMoviesPageSource
import com.redvelvet.repository.pagingSource.seeall.SeeAllPopularMoviesPageSource
import com.redvelvet.repository.pagingSource.seeall.SeeAllRecommendedMoviesPageSource
import com.redvelvet.repository.pagingSource.seeall.SeeAllSimilarMoviesPageSource
import com.redvelvet.repository.pagingSource.seeall.SeeAllTopRatedMoviesPageSource
import com.redvelvet.repository.pagingSource.seeall.SeeAllUpcomingMoviesPageSource
import com.redvelvet.repository.pagingSource.seealltv.SeeAllAiringTodayTvPageSource
import com.redvelvet.repository.pagingSource.seealltv.SeeAllOnTheAirTvPageSource
import com.redvelvet.repository.pagingSource.seealltv.SeeAllPopularTvPageSource
import com.redvelvet.repository.pagingSource.seealltv.SeeAllRecommendedTvShowsPageSource
import com.redvelvet.repository.pagingSource.seealltv.SeeAllTopRatedTvShowsPageSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
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

    override suspend fun getActorDetails(id: String): Actor {
        return wrapRemoteResponse { remoteDataSource.getActorDetails(id) }.toActor()
    }

    override suspend fun getActorKnownFor(id: String): List<CombinedResult> {
        return wrapRemoteResponse { remoteDataSource.getActorKnownFor(id) }
            .map { it.toCombinedResult() }
    }

    //endregion

    //region see all

    override suspend fun seeAllPopularMovie(page: Int?): Flow<PagingData<Movie>> {
        return seeAll(
            page = page,
            mapper = MovieDetailsDTO::toMovie,
            sourceFactory = ::SeeAllPopularMoviesPageSource
        )
    }

    override suspend fun seeAllUpcomingMovie(page: Int?): Flow<PagingData<Movie>> {
        return seeAll(
            page = page,
            mapper = MovieDetailsDTO::toMovie,
            sourceFactory = ::SeeAllUpcomingMoviesPageSource
        )
    }

    override suspend fun seeAllNowPlayingMovie(page: Int?): Flow<PagingData<Movie>> {
        return seeAll(
            page = page,
            mapper = MovieDetailsDTO::toMovie,
            sourceFactory = ::SeeAllNowPlayingMoviesPageSource
        )
    }

    override suspend fun seeAllTopRatedMovie(page: Int?): Flow<PagingData<Movie>> {
        return seeAll(
            page = page,
            mapper = MovieDetailsDTO::toMovie,
            sourceFactory = ::SeeAllTopRatedMoviesPageSource
        )
    }

    override suspend fun seeAllSimilarMovie(id: Int): Flow<PagingData<Movie>> {
        return seeAllWithId(
            id = id,
            sourceFactory = ::SeeAllSimilarMoviesPageSource,
            mapper = MovieDetailsDTO::toMovie
        )
    }

    override suspend fun seeAllRecommendedMovie(id: Int): Flow<PagingData<Movie>> {
        return seeAllWithId(
            id = id,
            sourceFactory = ::SeeAllRecommendedMoviesPageSource,
            mapper = MovieDetailsDTO::toMovie
        )
    }

    // endregion

    //region see all
    override suspend fun seeAllAiringTodayTv(page: Int?): Flow<PagingData<TvShow>> {
        return seeAll(
            page = page,
            mapper = TvShowDto::toTvShow,
            sourceFactory = ::SeeAllAiringTodayTvPageSource
        )
    }

    override suspend fun seeAllOnTheAir(page: Int?): Flow<PagingData<TvShow>> {
        return seeAll(
            page = page,
            mapper = TvShowDto::toTvShow,
            sourceFactory = ::SeeAllOnTheAirTvPageSource
        )
    }

    override suspend fun seeAllPopularTv(page: Int?): Flow<PagingData<TvShow>> {
        return seeAll(
            page = page,
            mapper = TvShowDto::toTvShow,
            sourceFactory = ::SeeAllPopularTvPageSource
        )
    }

    override suspend fun getAllEpisodes(tvId: String, seasonNumber: Int): List<EpisodeDetails> {
        return remoteDataSource.getAllEpisodes(
            tvId,
            seasonNumber
        ).episodeDto!!.map { it.toEpisodeDetails() }
    }

    override suspend fun seeAllTopRatedTv(): Flow<PagingData<TvShow>> {
        return seeAll(
            sourceFactory = ::SeeAllTopRatedTvShowsPageSource,
            mapper = TvShowDto::toTvShow
        )
    }

    override suspend fun seeAllRecommendedTv(id: Int): Flow<PagingData<TvShow>> {
        return seeAllWithId(
            id = id,
            sourceFactory = ::SeeAllRecommendedTvShowsPageSource,
            mapper = TvShowDto::toTvShow
        )
    }
    //endregion


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

    override suspend fun getPopularMovies(): List<Movie> {
        return remoteDataSource.getPopularMovies().map { it.toMovie() }
    }

    override suspend fun getUpComingMovies(): List<Movie> {
        return remoteDataSource.getUpComingMovies().map { it.toMovie() }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return remoteDataSource.getTopRatedMovies().map { it.toMovie() }
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return remoteDataSource.getNowPlayingMovies().map { it.toMovie() }
    }

    override suspend fun getAiringTodayTv(): List<TvShow> {
        return remoteDataSource.getAiringTodayTv().map{it.toTvShow()}
    }

    override suspend fun getPopularTv(): List<TvShow> {
        return remoteDataSource.getPopularTv().map{it.toTvShow()}
    }

    override suspend fun getOnTheAir(): List<TvShow> {
        return remoteDataSource.getOnTheAir().map{it.toTvShow()}
    }

    override suspend fun getTopRatedTv(): List<TvShow> {
        return remoteDataSource.getTopRatedTv().map{it.toTvShow()}
    }

    override suspend fun getAllSeasons(seriesId: Int): List<SeasonTvShow> {
        return remoteDataSource.getAllSeasons(
            seriesId
        ).seasonDtos!!.map { it!!.toSeasonTvShow() }
    }
    //endregion

    //region wrapper
    private fun <I : Any, O : Any> seeAll(
        page: Int? = null,
        sourceFactory: (RemoteDataSource) -> PagingSource<Int, I>,
        mapper: I.() -> O
    ): Flow<PagingData<O>> {
        return Pager(
            config = PagingConfig(pageSize = DEFAULT_PAGE_SIZE),
            pagingSourceFactory = { sourceFactory(remoteDataSource) }
        ).flow.map { pagingData ->
            pagingData.map { it.mapper() }
        }
    }

    private fun <I : Any, O : Any> seeAllWithId(
        id: Int,
        sourceFactory: (RemoteDataSource, Int) -> PagingSource<Int, I>,
        mapper: I.() -> O
    ): Flow<PagingData<O>> {
        return Pager(
            config = PagingConfig(pageSize = DEFAULT_PAGE_SIZE),
            pagingSourceFactory = { sourceFactory(remoteDataSource, id) }
        ).flow.map { pagingData ->
            pagingData.map { it.mapper() }
        }
    }

    //endregion
    companion object {
        private const val DEFAULT_PAGE_SIZE = 100
    }
}
