package com.mtv.app.movie.data.remote.tmdb

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    val results: List<MovieDto>
)
