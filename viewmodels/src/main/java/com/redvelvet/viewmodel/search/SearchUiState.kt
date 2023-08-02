package com.redvelvet.viewmodel.search

import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val mediaType: SearchMedia = SearchMedia.ALL,
    val inputText: String? = "",
    val searchPeopleResult: List<MediaUiState> = emptyList(),
    val searchResult: List<MediaUiState> = emptyList(),
    val isEmpty: Boolean = false,
    ):BaseUiState

data class MediaUiState(
    val mediaID: Int?,
    val mediaName: String?,
    val mediaImage: String?,
    val mediaPopularity: Double?,
    val mediaReleaseDate: String?,
    val mediaCountry: String?,
)

enum class SearchMedia {
    ALL,
    MOVIE,
    TV,
    PEOPLE
}


internal fun People.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = name,
        mediaImage = profileImage,
        mediaReleaseDate = birthday,
        mediaPopularity =  popularity,
        mediaCountry = country
    )

}

internal fun TvShow.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = name,
        mediaImage = image,
        mediaPopularity =popularity ,
        mediaReleaseDate = releaseDate,
        mediaCountry = country
        )
}

internal fun Movie.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = name,
        mediaImage = image,
        mediaPopularity = popularity,
        mediaReleaseDate = releaseDate,
        mediaCountry = country
        )
}