package com.mtv.app.movie.data.model

import kotlinx.serialization.Serializable


@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String
)