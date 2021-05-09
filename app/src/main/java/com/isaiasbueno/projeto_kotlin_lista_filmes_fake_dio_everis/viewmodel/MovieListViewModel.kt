package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.api.MovieRestApiTask
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.model.Movie
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.repository.MovieRepository

class MovieListViewModel: ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}