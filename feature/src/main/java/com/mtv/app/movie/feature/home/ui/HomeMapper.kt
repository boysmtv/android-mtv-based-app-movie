package com.mtv.app.movie.feature.home.ui

import com.mtv.app.movie.data.model.HomeResponse
import com.mtv.based.core.network.utils.Resource

fun Resource<HomeResponse>.toHomeUiState(): HomeUiState =
    when (this) {

        is Resource.Loading ->
            HomeUiState(loading = true)

        is Resource.Success ->
            HomeUiState(movies = data.results)

        is Resource.Error ->
            HomeUiState(error = error)
    }
