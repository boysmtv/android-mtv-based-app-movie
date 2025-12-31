package com.mtv.app.movie.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mtv.app.movie.data.model.CountryProbability
import com.mtv.app.movie.data.model.PredictionData
import com.mtv.based.core.network.utils.Resource
import com.mtv.based.uicomponent.core.component.dialog.dialogv1.DialogCenterV1
import com.mtv.based.uicomponent.core.component.loading.LoadingV2

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val predictionState by viewModel.prediction.collectAsState()
    val baseUiState by viewModel.baseUiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        when (val current = predictionState) {
            is Resource.Success -> {
                PredictionContent(current.data)
            }

            else -> {}
        }

        if (baseUiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                LoadingV2()
            }
        }

        baseUiState.errorDialog?.let {
            DialogCenterV1(
                state = it,
                onDismiss = viewModel::dismissError
            )
        }
    }
}

@Composable
private fun PredictionContent(
    data: PredictionData
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Name: ${data.name}",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Count: ${data.count}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Country Probability",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CountryList(data.country)
    }
}

@Composable
private fun CountryList(
    countries: List<CountryProbability>
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(
            items = countries,
            key = { it.countryId }
        ) { country ->
            CountryItem(country)
        }
    }
}

@Composable
private fun CountryItem(
    country: CountryProbability
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = country.countryId, style = MaterialTheme.typography.bodyMedium)
        Text(text = "${(country.probability * 100).toInt()}%", style = MaterialTheme.typography.bodyMedium)
    }
}
