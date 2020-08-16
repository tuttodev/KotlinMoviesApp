package com.example.kotlinmoviesapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinmoviesapp.R
import com.example.kotlinmoviesapp.domain.model.Movie
import kotlinx.android.synthetic.main.movie_row.view.*
import java.io.File

class MovieListAdapter(private var movieList: List<Movie>, private val context: Context): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.movie_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Movie, position: Int){
            Glide.with(context).load(item.poster).centerCrop().into(itemView.iv_avatar)
            itemView.tv_title.text = item.title
            itemView.tv_genre.text = item.genre
            itemView.tv_year.text = item.year
        }
    }
}