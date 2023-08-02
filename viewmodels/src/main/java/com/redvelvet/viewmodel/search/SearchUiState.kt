package com.redvelvet.viewmodel.search

import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val mediaType: SearchMedia = SearchMedia.ALL,
    val inputText: String = "",
    val searchPeopleResult: List<MediaUiState> = emptyList(),
    val searchResult: List<MediaUiState> = emptyList(),
    val isEmpty: Boolean = false,
) : BaseUiState

data class MediaUiState(
    val mediaID: Int = 0,
    val mediaName: String = "",
    val mediaImage: String = "",
    val mediaReleaseDate: String = "",
    val mediaCountry: String ="",
)

enum class SearchMedia {
    ALL,
    MOVIE,
    TV,
    PEOPLE
}

fun SearchResult.toMediaUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id ?:0,
        mediaName = name ?:"",
        mediaImage = posterPath?:"",
        mediaReleaseDate = releaseDate?:"",
        mediaCountry = originCountry?:""
    )
}

//fun People.toMediaUiState(): MediaUiState {
//    return MediaUiState(
//        mediaID = id,
//        mediaName = name,
//        mediaImage = profileImage,
//        mediaReleaseDate = birthday,
//        mediaCountry = country
//    )
//}

//fun TvShow.toMediaUiState(): MediaUiState {
//    return MediaUiState(
//        mediaID = id,
//        mediaName = name,
//        mediaImage = image,
//        mediaReleaseDate = releaseDate?:"",
//        mediaCountry = country?:""
//    )
//}
//
//fun Movie.toMediaUiState(): MediaUiState {
//    return MediaUiState(
//        mediaID = id,
//        mediaName = name,
//        mediaImage = image,
//        mediaReleaseDate = releaseDate,
//        mediaCountry = country
//    )
//}