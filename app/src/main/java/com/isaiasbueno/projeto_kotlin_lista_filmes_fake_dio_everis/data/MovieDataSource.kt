package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.data

import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>

}