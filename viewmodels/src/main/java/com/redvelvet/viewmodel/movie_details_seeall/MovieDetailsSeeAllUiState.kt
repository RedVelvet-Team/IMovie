package com.redvelvet.viewmodel.movie_details_seeall

import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.Constants

data class SeeAllTopCastUiState(
    val title: String = "Top Cast",
    val topCast: List<MovieTopCastUiState> = listOf(),
    val isLoading: Boolean = true,
    val error: ErrorUiState ? = null
) : BaseUiState

data class MovieTopCastUiState(
    val castId: Int = 0,
    val castName: String = "",
    val castImage: String = ""
)

fun (MovieTopCast.Cast).toMovieTopCastUiState(): MovieTopCastUiState {

    return MovieTopCastUiState(
        castId = this.id,
        castName = this.name,
        castImage = Constants.BASE_IMAGE_URL + this.profilePath
    )

}


data class SeeAllImagesUiState(
    val title: String = "Images",
    val images: List<MovieImagesUiState> = listOf(),
    val isLoading: Boolean = true,
    val error: ErrorUiState ? = null
) : BaseUiState

data class MovieImagesUiState(
    val id: String = "",
    val mediaImage: String = ""
)


fun (MovieImages.Poster).toMovieImagesUiState(): MovieImagesUiState {
    return MovieImagesUiState(
            mediaImage = Constants.BASE_IMAGE_URL + this.filePath,
        )
}


data class SeeAllReviewsUiState(
    val title: String = "Reviews",
    val reviews: List<MovieReviewsUiState> = listOf(),
    val isLoading: Boolean = true,
    val error: ErrorUiState ? = null
) : BaseUiState

data class MovieReviewsUiState(
    val reviewId: String = "",
    val reviewAuthor: String = "",
    val reviewDate: String = "",
    val reviewStars: Double = 0.0,
    val reviewDescription: String = "",
)

fun (MovieReviews.Result).toMovieReviewsUiState(): MovieReviewsUiState {
    return MovieReviewsUiState(
            reviewId = this.id,
            reviewAuthor = this.username,
            reviewDescription = this.content,
            reviewDate = this.createdAt,
            reviewStars = this.rating,
        )


}