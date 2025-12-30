package com.mtv.app.movie.domain.usecase

import com.mtv.app.movie.data.model.Movie
import com.mtv.app.movie.data.repository.MovieRepository

class GetFavoriteMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): List<Movie> =
        repository.getFavoriteMovies()
}
