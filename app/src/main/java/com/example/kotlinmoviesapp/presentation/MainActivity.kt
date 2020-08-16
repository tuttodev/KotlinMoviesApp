package com.example.kotlinmoviesapp.presentation

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.View.inflate
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmoviesapp.R
import com.example.kotlinmoviesapp.data.MoviesDataSourceImpl
import com.example.kotlinmoviesapp.domain.repo.MoviesRepoImpl
import com.example.kotlinmoviesapp.presentation.adapter.MovieListAdapter
import com.example.kotlinmoviesapp.presentation.viewmodel.MoviesViewModel
import com.example.kotlinmoviesapp.presentation.viewmodel.MoviesViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_movie.view.*

class MainActivity : AppCompatActivity() {

    private val moviesViewModel by lazy {
        ViewModelProvider(this, MoviesViewModelFactory(MoviesRepoImpl(MoviesDataSourceImpl()))).get(MoviesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        moviesViewModel.getMovies().observe(this, Observer {
            rv_movies.adapter =
                MovieListAdapter(
                    it,
                    this
                )
        })
    }

    fun setupRecyclerView(){
        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.add_new_movie -> {
                showNewMovieAlertDialog()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showNewMovieAlertDialog(){
        val dialogView = LayoutInflater.from(this).inflate(R.layout.new_movie,null)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Nueva pelicula")
        builder.setView(dialogView)
        builder.setNegativeButton("Cancelar") { p0, p1 -> p0?.dismiss() }
        builder.setPositiveButton("Crear") { p0, p1 ->
            val title: String = dialogView.tv_title.text.toString()
            val genre: String = dialogView.tv_genre.text.toString()
            val year: String = dialogView.tv_year.text.toString()
            val poster: String = dialogView.tv_poster.text.toString()
            moviesViewModel.saveNewMovie(title, year, genre, poster)
        }
        val alert = builder.create()
        alert.show()
    }
}