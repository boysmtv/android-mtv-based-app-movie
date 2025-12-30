package com.mtv.app.movie.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    val results: List<Movie>
)

