package com.redvelvet.viewmodel.utils

import com.redvelvet.viewmodel.search.SearchCardUiState
import java.util.concurrent.TimeUnit

fun SearchCardUiState.getFullImage() = "https://image.tmdb.org/t/p/w500$image"

fun SearchCardUiState.isPerson() = country.isEmpty() && releaseDate.isEmpty()

fun Long.formatDuration(): String {
    if (this <= 0L) {
        return "..."
    }

    val hours = TimeUnit.MILLISECONDS.toHours(this)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(this) % 60
    val seconds = TimeUnit.MILLISECONDS.toSeconds(this) % 60

    return when {
        hours > 0 -> {
            String.format("%02dh:%02dm:%02ds", hours, minutes, seconds)
        }
        minutes > 0 -> {
            String.format("%02dm:%02ds", minutes, seconds)
        }
        else -> {
            String.format("%02ds", seconds)
        }
    }
}
