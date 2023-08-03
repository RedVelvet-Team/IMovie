package com.redvelvet.viewmodel.search

import com.redvelvet.entities.search.SearchResult
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val mediaType: SearchMedia = SearchMedia.ALL,
    val inputText: String = "",
    val searchResult: List<MediaUiState> = emptyList(),
    val isEmpty: Boolean = true,
) : BaseUiState

data class MediaUiState(
    val mediaID: Int = 0,
    val mediaName: String = "",
    val mediaImage: String = "",
    val mediaType: String = "",
    val mediaReleaseDate: String = "",
    val mediaCountry: String ="",
){
    fun getFullImage() = "https://image.tmdb.org/t/p/w500$mediaImage"
    fun isPerson() = mediaCountry.isEmpty() && mediaReleaseDate.isEmpty()
}

enum class SearchMedia {
    ALL,
    MOVIE,
    TV,
    PEOPLE
}

fun SearchResult.toMediaUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id ?:0,
        mediaName = getMediaName() ?:"",
        mediaImage = getImage()?:"",
        mediaType = mediaType ?: "",
        mediaReleaseDate = getDate()?:"",
        mediaCountry = language?:""
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