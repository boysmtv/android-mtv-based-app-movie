package com.mtv.app.movie.data.remote.tmdb

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    val poster_path: String?
)
