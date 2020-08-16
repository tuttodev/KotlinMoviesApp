package com.example.kotlinmoviesapp.data

import androidx.lifecycle.LiveData
import com.example.kotlinmoviesapp.domain.model.Movie

interface MoviesDataSource {
    fun getMovies() : LiveData<List<Movie>>
    fun saveNewMovie(movie: Movie)
}