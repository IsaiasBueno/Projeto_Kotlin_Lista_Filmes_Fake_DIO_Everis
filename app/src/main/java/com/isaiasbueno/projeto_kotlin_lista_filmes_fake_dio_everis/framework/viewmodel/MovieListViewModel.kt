package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.framework.api.MovieRestApiTask
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.data.MovieRepository
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.domain.Movie
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.implementations.MovieDataSourceImplementation
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.usecase.MoviesListUseCase

class MovieListViewModel: ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}