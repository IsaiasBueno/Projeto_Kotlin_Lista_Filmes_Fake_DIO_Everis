package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.repository

import android.util.Log
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.api.MovieRestApiTask
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()


    fun getAllMovies(): List<Movie> {

        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }

        return movieList
    }


}