package com.redvelvet.ui.screen.movieDetails

interface MovieDetailsUiEvent {
    fun onMovieFavorite(id: Int)
    fun onMovieSave(id: Int)
    fun onBack()
    fun onPlayTrailer()
    fun onMovieCategory(category: String)
    fun onTopCastSeeAll()
    fun onCast(id: Int)
    fun onMovieKeyword(id: Int)
    fun onSimilarMovieSeeAll()
    fun onRecommendedMovieSeeAll()
    fun onMovie(id: Int)
    fun onMovieImagesSeeAll()
    fun onMovieImage(id: Int)
    fun onMovieReviewsSeeAll()
    fun onMovieReview(id: Int)

}