package com.amirhusseinsoori.data.network.dataSourse.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.amirhusseinsoori.data.BaseTest
import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.dataSource.remote.MovieRemote
import com.amirhusseinsoori.domain.exception.CustomResult
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieRemoteImpTest: BaseTest() {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var productRemoteDataSource: MovieRemote

    @Before
    override fun setup() {
        super.setup()
        productRemoteDataSource =
            MovieRemoteImp(getApiService(MovieApi::class.java))
    }


    @Test
    fun giveFakeMovies_returnSuccess() = runBlocking {
        productRemoteDataSource.fetchAllIMovies().test(timeoutMs = 60_000L) {
            cancelAndIgnoreRemainingEvents()
        }
    }
}