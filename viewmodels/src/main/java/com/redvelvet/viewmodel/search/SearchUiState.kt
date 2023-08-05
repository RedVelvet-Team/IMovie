package com.redvelvet.viewmodel.search

import androidx.paging.PagingData
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val selectedMediaType: SearchMedia = SearchMedia.ALL,
    val inputText: String = "",
    val searchResult: PagingData<List<SearchCardUiState>> = PagingData.empty(),
    val isEmpty: Boolean = true,

    ) : BaseUiState {
    fun getCategories(): List<CategoryUiState> {
        return listOf(
            CategoryUiState(text = "All", type = SearchMedia.ALL),
            CategoryUiState(text = "Movie", type = SearchMedia.MOVIE),
            CategoryUiState(text = "Person", type = SearchMedia.PEOPLE),
            CategoryUiState(text = "Tv show", type = SearchMedia.TV),
        )
    }
}

data class SearchCardUiState(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val type: String = "",
    val releaseDate: String = "",
    val country: String = "",
) {
    fun getFullImage() = "https://image.tmdb.org/t/p/w500$image"
    fun isPerson() = country.isEmpty() && releaseDate.isEmpty()
}

data class CategoryUiState(
    val text: String = "",
    val type: SearchMedia = SearchMedia.ALL
)

enum class SearchMedia {
    ALL,
    MOVIE,
    TV,
    PEOPLE
}

fun SearchResult.toMediaUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id ?: 0,
        name = getMediaName() ?: "",
        image = getImage() ?: "",
        type = mediaType ?: "",
        releaseDate = getDate() ?: "",
        country = language ?: ""
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