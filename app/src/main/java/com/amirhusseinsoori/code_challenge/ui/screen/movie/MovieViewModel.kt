package com.amirhusseinsoori.code_challenge.ui.screen.movie

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MovieViewModel @Inject constructor(
    repository: MovieRepository
) : ViewModel() {
    val getAllImages = repository.getAllIMovies()
}