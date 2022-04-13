package com.amirhusseinsoori.code_challenge.ui.screen.movie

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.data.repository.MovieRepositoryImp
import com.amirhusseinsoori.domain.reository.MovieRepository
import com.amirhusseinsoori.domain.useCase.ListMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MovieViewModel @Inject constructor(
    useCase: ListMovieUseCase
) : ViewModel() {
    val getAllImages = useCase.execute()
}