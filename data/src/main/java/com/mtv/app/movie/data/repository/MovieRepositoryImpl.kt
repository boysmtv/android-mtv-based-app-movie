package com.mtv.app.movie.data.repository

import com.mtv.app.movie.data.mapper.toDomain
import com.mtv.app.movie.data.model.Movie
import com.mtv.app.movie.data.remote.tmdb.TmdbApi

//class MovieRepositoryImpl(
//    private val api: TmdbApi
//) : MovieRepository {
//
//    override suspend fun getPopularMovies(): List<Movie> =
//        api.getPopularMovie()
//            .results
//            .map { it.toDomain() }
//
//    override suspend fun searchMovies(query: String): List<Movie> =
//        api.searchMovies(query)
//            .results
//            .map { it.toDomain() }
//
//    override suspend fun getFavoriteMovies(): List<Movie> =
//        emptyList()
//}
