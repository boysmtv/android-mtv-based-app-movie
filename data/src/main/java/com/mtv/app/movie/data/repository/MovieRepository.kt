package com.mtv.app.movie.data.repository

import com.mtv.app.movie.data.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun searchMovies(query: String): List<Movie>
    suspend fun getFavoriteMovies(): List<Movie>
}