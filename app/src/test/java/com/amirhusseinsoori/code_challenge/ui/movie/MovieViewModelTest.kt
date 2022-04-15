package com.amirhusseinsoori.code_challenge.ui.movie

import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.domain.reository.MovieRepository
import com.amirhusseinsoori.domain.useCase.ListMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MovieViewModelTest {

    @OptIn(ExperimentalPagingApi::class)
    lateinit var movieViewModel: MovieViewModel

    private lateinit var useCase: ListMovieUseCase
    private val mockRepository = Mockito.mock(MovieRepository::class.java)

    @OptIn(ExperimentalPagingApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @OptIn(ExperimentalPagingApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        useCase = ListMovieUseCase(mockRepository)
        movieViewModel = MovieViewModel(useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun launchEvent() {
        runBlocking {
            launch(Dispatchers.Main) {
                movieViewModel.event()
            }
        }

    }

}