package com.redvelvet.usecase.usecase.seeall

import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetAllSeasonsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(seriesId: Int): List<SeasonTvShow> {
        return movieRepository.getAllSeasons(seriesId)
    }
}