package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.R
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.model.Movie
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            populateList(list)
        })
    }

    private fun populateList(list: List<Movie>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

}