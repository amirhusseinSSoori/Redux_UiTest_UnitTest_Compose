package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.reository.DetailsRepository
import com.amirhusseinsoori.domain.reository.MovieRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ListMovieUseCaseTest{
    private lateinit var useCase: ListMovieUseCase
    private val mockRepository = Mockito.mock(MovieRepository::class.java)
    @Before
    fun setup() {
        useCase = ListMovieUseCase(mockRepository)
    }

    @Test
    fun getShowAllMovie() {
        runBlocking {
            launch {
                useCase.execute()
                Mockito.verify(mockRepository).getAllIMovies()
                this.cancel()
            }
            return@runBlocking
        }
    }
}