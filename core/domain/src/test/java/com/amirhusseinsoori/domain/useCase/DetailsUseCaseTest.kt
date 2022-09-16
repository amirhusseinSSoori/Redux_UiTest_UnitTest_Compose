package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.reository.DetailsRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class DetailsUseCaseTest{
    private lateinit var useCase: DetailsUseCase
    private val mockRepository = Mockito.mock(DetailsRepository::class.java)
    @Before
    fun setup() {
        useCase = DetailsUseCase(mockRepository)
    }

    @Test
    fun getShowDetailsMovie() {
        runBlocking {
            launch {
                useCase.execute(675353)
                Mockito.verify(mockRepository).getDetailsRepository(675353)
                this.cancel()
            }
            return@runBlocking
        }
    }
}