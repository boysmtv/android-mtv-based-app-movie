package com.mtv.app.movie.feature.home.ui

import com.mtv.app.movie.data.model.Movie
import com.mtv.based.core.network.utils.UiError
import kotlinx.serialization.Serializable

@Serializable
data class HomeUiState(
    val loading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: UiError? = null
)