package com.redvelvet.usecase.usecase.tvshow

import com.redvelvet.usecase.repository.TvShowRepository
import javax.inject.Inject

class AddTvShowRatingUseCase@Inject constructor(
    private val repository: TvShowRepository
) {
    suspend operator fun invoke(seriesRating: Double, seriesId: Int, sessionId: String) =
        repository.addTvShowRating(seriesRating,seriesId,sessionId)
}