package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.api

import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}