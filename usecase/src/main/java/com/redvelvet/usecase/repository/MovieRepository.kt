package com.redvelvet.usecase.repository

import androidx.paging.PagingData
import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.entities.Player
import com.redvelvet.entities.Question
import com.redvelvet.entities.Genre
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
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

    //region game
    suspend fun getMovieQuestions(): List<Question>
    suspend fun getTvQuestions(): List<Question>
    suspend fun getActingQuestions(): List<Question>
    suspend fun getPlayerInfo(): Player
    suspend fun addPlayer()
    suspend fun getHighestScorePlayer(): List<Player>

    suspend fun savePlayerScore(score: Int)
    //endregion
    fun multiSearch(query: String, page: Int? = 1): Flow<PagingData<SearchResult>>
    fun searchPeople(query: String, page: Int? = 1): Flow<PagingData<Actor>>
    fun searchMovie(query: String, page: Int? = 1): Flow<PagingData<Movie>>
    fun searchTvShows(query: String, page: Int? = 1): Flow<PagingData<TvShow>>

    //region see all
    suspend fun seeAllPopularMovie(page: Int?): Flow<PagingData<Movie>>
    suspend fun seeAllUpcomingMovie(page: Int?): Flow<PagingData<Movie>>
    suspend fun seeAllNowPlayingMovie(page: Int?): Flow<PagingData<Movie>>
    suspend fun seeAllSimilarMovie(id: Int): Flow<PagingData<Movie>>
    suspend fun seeAllTopRatedMovie(page: Int?): Flow<PagingData<Movie>>
    suspend fun seeAllRecommendedMovie(id: Int): Flow<PagingData<Movie>>

    //endregion

    suspend fun getActorDetails(id: String): Actor
    suspend fun getActorKnownFor(id: String): List<CombinedResult>

    //region see all
    suspend fun seeAllAiringTodayTv(page: Int?): Flow<PagingData<TvShow>>
    suspend fun seeAllOnTheAir(page: Int?): Flow<PagingData<TvShow>>
    suspend fun seeAllPopularTv(page: Int?): Flow<PagingData<TvShow>>
    suspend fun getAllEpisodes(tvId: String, seasonNumber: Int): List<EpisodeDetails>
    suspend fun seeAllTopRatedTv(): Flow<PagingData<TvShow>>
    suspend fun seeAllRecommendedTv(id: Int): Flow<PagingData<TvShow>>
    //endregion

    //region Movie Details
    suspend fun getMovieDetailsById(movieId: Int): MovieDetails
    suspend fun getMovieImagesByID(movieId: Int): MovieImages
    suspend fun getMovieKeyWordsByID(movieId: Int): MovieKeyWords
    suspend fun getMovieRecommendationsByID(movieId: Int): MovieRecommendations
    suspend fun getMovieReviewsByID(movieId: Int): MovieReviews
    suspend fun getMovieSimilarByID(movieId: Int): MovieSimilar
    suspend fun getMovieTopCastByID(movieId: Int): MovieTopCast
    suspend fun getAllSeasons(seriesId: Int): List<SeasonTvShow>

    //endregion

    //region movies
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getUpComingMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getNowPlayingMovies(): List<Movie>

    //endregion
    suspend fun getAiringTodayTv(): List<TvShow>
    suspend fun getPopularTv(): List<TvShow>
    suspend fun getOnTheAir(): List<TvShow>
    suspend fun getTopRatedTv(): List<TvShow>

    //region category
    suspend fun getMovieCategory(): List<Genre>
    suspend fun getTvCategory(): List<Genre>
    suspend fun getMovieCategoryById(id: Int): Flow<PagingData<Movie>>
    suspend fun getTvCategoryById(id: Int): Flow<PagingData<TvShow>>
    //endregion
}