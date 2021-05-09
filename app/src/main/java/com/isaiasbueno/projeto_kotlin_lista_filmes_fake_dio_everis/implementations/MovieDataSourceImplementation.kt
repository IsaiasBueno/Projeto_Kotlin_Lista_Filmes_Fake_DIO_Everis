package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.implementations

import android.util.Log
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.framework.api.MovieRestApiTask
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.data.MovieDataSource
import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.domain.Movie

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDataSource {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()


    override fun getAllMovies(): List<Movie> {
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