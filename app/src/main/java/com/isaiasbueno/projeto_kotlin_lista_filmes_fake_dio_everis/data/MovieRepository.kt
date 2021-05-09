package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()

}