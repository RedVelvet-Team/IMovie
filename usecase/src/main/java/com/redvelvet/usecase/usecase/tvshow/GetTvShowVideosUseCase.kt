package com.redvelvet.usecase.usecase.tvshow

import com.redvelvet.usecase.repository.TvShowRepository
import javax.inject.Inject

class GetTvShowVideosUseCase @Inject constructor(
    private val repository: TvShowRepository
) {
    suspend operator fun invoke(seriesId: Int) =
        repository.getTvShowVideos(seriesId)
}