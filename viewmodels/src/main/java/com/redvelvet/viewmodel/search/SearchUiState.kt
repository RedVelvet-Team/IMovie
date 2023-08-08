package com.redvelvet.viewmodel.search

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val selectedMediaType: SearchMedia = SearchMedia.ALL,
    val inputText: String = "",
    val searchResult: Flow<PagingData<SearchCardUiState>> = flow {  },
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

fun SearchResult.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id ?: 0,
        name = getMediaName() ?: "",
        image = getImage() ?: "",
        type = mediaType ?: "",
        releaseDate = getDate() ?: "",
        country = language ?: ""
    )
}

fun Movie.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id,
        name = name,
        image = image,
        type = "Movie",
        releaseDate = releaseDate,
        country = country
    )
}

fun People.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id,
        name = name,
        image = profileImage,
        type = "People",
        releaseDate = birthday ?: "",
        country = country
    )
}

fun TvShow.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id,
        name = name,
        image = image,
        type = "TvShow",
        releaseDate = releaseDate ?: "",
        country = country ?: ""
    )
}