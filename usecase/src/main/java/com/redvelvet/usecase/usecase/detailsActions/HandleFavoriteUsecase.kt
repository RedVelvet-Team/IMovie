package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.usecase.repository.LibraryRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.auth.GetSavedAccountDetailsIdUsecase
import com.redvelvet.usecase.usecase.library.GetMovieFavoritesUsecase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class HandleFavoriteUsecase @Inject constructor(
    private val getMovieFavoritesUsecase: GetMovieFavoritesUsecase,
    private val toggleMediaInFavoritesUsecase: ToggleMediaInFavoritesUsecase,
    private val libraryRepository: LibraryRepository,
    private val getAccountId: GetSavedAccountDetailsIdUsecase,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
    ): String {
        return coroutineScope {
            val movieFavoritesDeferred = async {getMovieFavorites() }
            val list = movieFavoritesDeferred.await()
            val isListHasItem = list.any { it.id == mediaId }
            if (isListHasItem) {
                toggleMediaInFavoritesUsecase.invoke(mediaType, mediaId, false)
            } else {
                toggleMediaInFavoritesUsecase.invoke(mediaType, mediaId, true)
            }
        }
    }

    private suspend fun getMovieFavorites(): List<MovieDetails> {
        return libraryRepository.getFavoriteMovies(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }
}