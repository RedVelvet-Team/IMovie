package com.redvelvet.entities.movie.details

/*data class MovieFullDetails(
    val details:MovieDetails,
    val images: MovieImages,
    val keyWords: MovieKeyWords,
    val recommendations: MovieRecommendations,
    val reviews: MovieReviews,
    val similar: MovieSimilar,
    val topCast: MovieTopCast
)*/

data class MovieFullDetails(
    val details: MovieDetails,
    val images: MovieImages,
    val keyWords: MovieKeyWords,
    val recommendations: MovieRecommendations,
    val reviews: MovieReviews,
    val similar: MovieSimilar,
    val topCast: MovieTopCast
) {
    data class Builder(
        private var details: MovieDetails? = null,
        private var images: MovieImages? = null,
        private var keyWords: MovieKeyWords? = null,
        private var recommendations: MovieRecommendations? = null,
        private var reviews: MovieReviews? = null,
        private var similar: MovieSimilar? = null,
        private var topCast: MovieTopCast? = null
    ) {
        fun details(details: MovieDetails) = apply { this.details = details }
        fun images(images: MovieImages) = apply { this.images = images }
        fun keyWords(keyWords: MovieKeyWords) = apply { this.keyWords = keyWords }
        fun recommendations(recommendations: MovieRecommendations) = apply { this.recommendations = recommendations }
        fun reviews(reviews: MovieReviews) = apply { this.reviews = reviews }
        fun similar(similar: MovieSimilar) = apply { this.similar = similar }
        fun topCast(topCast: MovieTopCast) = apply { this.topCast = topCast }

        fun build() = MovieFullDetails(
            details ?: throw IllegalArgumentException("Details must not be null"),
            images ?: throw IllegalArgumentException("Images must not be null"),
            keyWords ?: throw IllegalArgumentException("KeyWords must not be null"),
            recommendations ?: throw IllegalArgumentException("Recommendations must not be null"),
            reviews ?: throw IllegalArgumentException("Reviews must not be null"),
            similar ?: throw IllegalArgumentException("Similar must not be null"),
            topCast ?: throw IllegalArgumentException("TopCast must not be null")
        )
    }
}
