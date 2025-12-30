package com.mtv.app.movie.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PredictionData(
    val count: Int,
    val name: String,
    val country: List<CountryProbability>
)

@Serializable
data class CountryProbability(
    @SerialName("country_id")
    val countryId: String,
    val probability: Double
)
