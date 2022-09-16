package com.amirhusseinsoori.data.repository

import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@OptIn(ExperimentalPagingApi::class)
class DetailsRepositoryImpTest{

    private lateinit var repository: DetailsRepositoryImp
    private val mockRemote= Mockito.mock(DetailsRemote::class.java)

    @Before
    fun setup() {
        repository = DetailsRepositoryImp(mockRemote)
    }

    @Test
    fun getShowAllMovie() {
        runBlocking {
            launch {
                repository.getDetailsRepository(53722)
                Mockito.verify(mockRemote).fetchDetailsRepository(53722)
                this.cancel()
            }
            return@runBlocking
        }
    }
}