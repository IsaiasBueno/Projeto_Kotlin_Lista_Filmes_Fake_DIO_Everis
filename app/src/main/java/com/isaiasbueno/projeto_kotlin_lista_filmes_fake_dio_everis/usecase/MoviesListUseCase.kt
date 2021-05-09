package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.usecase

import com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.data.MovieRepository

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}