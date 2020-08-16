package com.example.kotlinmoviesapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmoviesapp.domain.model.Movie
import com.example.kotlinmoviesapp.domain.repo.MoviesRepo

class MoviesViewModel(private val moviesRepo: MoviesRepo) : ViewModel() {
    private val movies = MutableLiveData<List<Movie>>()

    fun getMovies(): LiveData<List<Movie>>{
        return moviesRepo.getMovies()
    }

    fun saveNewMovie(title: String, year: String, genre: String, poster: String){
        moviesRepo.saveNewMovie(Movie(title, year, genre, poster))
    }
}