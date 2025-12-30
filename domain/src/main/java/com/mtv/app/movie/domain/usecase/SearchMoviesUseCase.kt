package com.mtv.app.movie.domain.usecase

import com.mtv.app.movie.data.model.Movie
import com.mtv.app.movie.data.repository.MovieRepository

class SearchMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String): List<Movie> =
        repository.searchMovies(query)
}
