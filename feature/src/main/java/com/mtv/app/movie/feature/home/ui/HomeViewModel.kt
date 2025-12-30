package com.mtv.app.movie.feature.home.ui

import com.mtv.app.core.provider.based.BaseViewModel
import com.mtv.app.movie.data.model.PredictionData
import com.mtv.app.movie.domain.usecase.GetPopularMoviesUseCase
import com.mtv.based.core.network.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNamePrediction: GetPopularMoviesUseCase
) : BaseViewModel() {

    val prediction = MutableStateFlow<Resource<PredictionData>>(Resource.Loading)

    init {
        load()
    }

    fun load() {
        launchUseCase(prediction) {
            getNamePrediction(Unit)
        }
    }
}

