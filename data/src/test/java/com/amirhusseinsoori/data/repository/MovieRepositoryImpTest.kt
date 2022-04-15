package com.amirhusseinsoori.data.repository

import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.amirhusseinsoori.domain.dataSource.remote.MovieRemote
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
@OptIn(ExperimentalPagingApi::class)
class MovieRepositoryImpTest{
    private lateinit var repository: MovieRepositoryImp
    private val mockRemote= Mockito.mock(MovieRemote::class.java)

    @Before
    fun setup() {
        repository = MovieRepositoryImp(mockRemote)
    }

    @Test
    fun getShowAllMovie() {
        runBlocking {
            launch {
                repository.getAllIMovies()
                Mockito.verify(mockRemote).fetchAllIMovies()
                this.cancel()
            }
            return@runBlocking
        }
    }
}