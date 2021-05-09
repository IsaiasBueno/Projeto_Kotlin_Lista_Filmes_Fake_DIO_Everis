package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.R
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.domain.Movie
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            movieTitle.text = moviesList[position].titulo
            movieImage.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size



}