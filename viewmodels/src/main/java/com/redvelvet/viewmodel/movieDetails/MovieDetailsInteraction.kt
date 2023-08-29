package com.redvelvet.viewmodel.movieDetails

interface MovieDetailsInteraction {
    fun onClickFavorite(movieId: Int, mediaType: String)
    fun onClickSave(movieId: Int)
    fun onClickPlayTrailer(movieUrl: String)
    fun onClickGenre(genre: String)
    fun onClickRateMovie(movieId: Int, rate: Double)
    fun onClickTopCastSeeAll(movieId: String)
    fun onClickCast(castId: Int)

    fun onClickSimilarMoviesSeeAll(movieId: String)

    fun onClickMovie(movieId: String)

    fun onClickMovieImagesSeeAll(movieId: String)
    fun onClickPreviewImage(movieImageId: String)

    fun onClickReviewsSeeAll(movieId: String)
    fun onClickReview(reviewId: String)
    fun onClickRecommendationsMoviesSeeAll(movieId: String)
}