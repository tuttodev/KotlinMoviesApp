package com.example.kotlinmoviesapp.domain.repo

import androidx.lifecycle.LiveData
import com.example.kotlinmoviesapp.domain.model.Movie

interface MoviesRepo {
    fun getMovies() : LiveData<List<Movie>>
    fun saveNewMovie(movie: Movie)
}