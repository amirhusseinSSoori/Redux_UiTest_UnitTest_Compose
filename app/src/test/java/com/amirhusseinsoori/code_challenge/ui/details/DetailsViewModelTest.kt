package com.amirhusseinsoori.code_challenge.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.domain.reository.DetailsRepository
import com.amirhusseinsoori.domain.useCase.DetailsUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class DetailsViewModelTest {
    @OptIn(ExperimentalPagingApi::class)
    lateinit var detailsViewModel: DetailsViewModel

    private lateinit var useCase: DetailsUseCase
    private val mockRepository = Mockito.mock(DetailsRepository::class.java)

    @OptIn(ExperimentalPagingApi::class, kotlinx.coroutines.DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        val handle = SavedStateHandle()
        Dispatchers.setMain(mainThreadSurrogate)
        useCase = DetailsUseCase(mockRepository)
        detailsViewModel = DetailsViewModel(useCase, handle)

    }

    @Test
    fun launchEvent() {
        runBlocking {
            launch(Dispatchers.Main
            ) {
                detailsViewModel.event(35345)
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


}