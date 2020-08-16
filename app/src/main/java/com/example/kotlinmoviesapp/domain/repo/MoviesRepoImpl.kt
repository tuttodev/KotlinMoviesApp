package com.example.kotlinmoviesapp.domain.repo

import androidx.lifecycle.LiveData
import com.example.kotlinmoviesapp.data.MoviesDataSource
import com.example.kotlinmoviesapp.domain.model.Movie

class MoviesRepoImpl(private val movieDataSource: MoviesDataSource) : MoviesRepo {
    override fun getMovies(): LiveData<List<Movie>> {
        return movieDataSource.getMovies();
    }

    override fun saveNewMovie(movie: Movie) {
        movieDataSource.saveNewMovie(movie)
    }

}