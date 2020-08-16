package com.example.kotlinmoviesapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmoviesapp.domain.model.Movie

class MoviesDataSourceImpl : MoviesDataSource {

    private val movies = MutableLiveData<List<Movie>>(
        mutableListOf(
            Movie(
                "Superman",
                "2016",
                "Acción",
                "https://www.tonica.la/__export/1593024463060/sites/debate/img/2020/06/24/henry-cavill-superman-portada.jpg_423682103.jpg"
            ),
            Movie(
                "Annabelle",
                "2001",
                "Miedo",
                "https://elintranews.com/wp-content/uploads/2020/08/8c2790dd8015b3b8a845a7caf7384369-1.jpg"
            ),
            Movie(
                "Batman Begins",
                "2005",
                "Acción",
                "https://m.media-amazon.com/images/M/MV5BZmUwNGU2ZmItMmRiNC00MjhlLTg5YWUtODMyNzkxODYzMmZlXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg"
            ),
            Movie(
                "Titanic",
                "1997",
                "Suspenso",
                "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg"
            ),
            Movie(
                "Harry Potter and the Deathly Hallows: Part 2",
                "2011",
                "Acción",
                "https://m.media-amazon.com/images/M/MV5BMjIyZGU4YzUtNDkzYi00ZDRhLTljYzctYTMxMDQ4M2E0Y2YxXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg"
            )
        )
    )

    override fun getMovies(): LiveData<List<Movie>> {
        return movies
    }

    override fun saveNewMovie(movie: Movie) {
        var data = movies.value?.toMutableList();
        data?.add(movie)
        movies.value = data
    }
}