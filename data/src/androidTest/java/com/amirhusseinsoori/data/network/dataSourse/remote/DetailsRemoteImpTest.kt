package com.amirhusseinsoori.data.network.dataSourse.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.amirhusseinsoori.data.BaseTest
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class DetailsRemoteImpTest : BaseTest() {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var productRemoteDataSource: DetailsRemote

    @Before
    override fun setup() {
        super.setup()
        productRemoteDataSource =
            DetailsRemoteImp(getApiService(MovieApi::class.java))
    }


    @Test
    fun getFakeDetails_returnSuccess() = runBlocking {
        productRemoteDataSource.fetchDetailsRepository(675353).test(timeoutMs = 60_000L) {
            awaitItem().let {
                Truth.assertThat(it).isInstanceOf(Result.success(it)::class.java)
                Truth.assertThat(it).isNotNull()
            }

           cancelAndIgnoreRemainingEvents()
        }
    }
}