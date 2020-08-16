package com.example.kotlinmoviesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmoviesapp.domain.repo.MoviesRepo

class MoviesViewModelFactory(private val moviesRepo: MoviesRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MoviesRepo::class.java).newInstance(moviesRepo)
    }
}