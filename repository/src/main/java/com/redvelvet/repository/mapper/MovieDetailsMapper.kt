package com.redvelvet.repository.mapper

import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO

fun MovieImagesDTO.toDomain(): MovieImages{
    return MovieImages(
        backdrops = this.backdrops.map { MovieImages.Backdrop(it.filePath) },
        id = this.id,
        logos = this.logos.map { MovieImages.Logo(it.filePath)},
        posters = this.posters.map { MovieImages.Poster(it.filePath) }
    )
}



