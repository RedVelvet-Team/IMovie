package com.redvelvet.viewmodel.movieDetails

interface MovieDetailsInteraction {
    fun onClickFavorite(movieId: Int, mediaType: String)
    fun onClickSave(movieId: Int)
    fun onClickPlayTrailer(movieUrl: String)
    fun onClickGenre(genre: String)
    fun onClickRateMovie(movieId: Int, rate: Double)
    fun onClickTopCastSeeAll()
    fun onClickCast(castId: Int)

    fun onClickSimilarMoviesSeeAll()

    fun onClickMovie(movieId: Int)

    fun onClickMovieImagesSeeAll()
    fun onClickPreviewImage(movieImageId: Int)

    fun onClickReviewsSeeAll()
    fun onClickReview(reviewId: Int)
    fun onClickRecommendationsMoviesSeeAll()
}