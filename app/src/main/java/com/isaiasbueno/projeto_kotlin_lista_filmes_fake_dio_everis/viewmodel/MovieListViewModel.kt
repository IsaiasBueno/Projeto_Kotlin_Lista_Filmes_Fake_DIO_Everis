package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.model.Movie

class MovieListViewModel: ViewModel() {

    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            titulo = "Titanic",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),
        Movie(
            id = 1,
            titulo = "Central do Brasil",
            descricao = null,
            imagem = null,
            dataLancamento = null
        )
    )

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _moviesList.value = listOfMovies
    }

}