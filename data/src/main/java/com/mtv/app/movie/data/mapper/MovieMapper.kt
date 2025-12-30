package com.mtv.app.movie.data.mapper

import com.mtv.app.movie.data.model.Movie
import com.mtv.app.movie.data.remote.tmdb.MovieDto

fun MovieDto.toDomain(): Movie =
    Movie(
        id = id,
        title = title,
        posterUrl = poster_path?.let {
            "https://image.tmdb.org/t/p/w500$it"
        }.orEmpty()
    )
