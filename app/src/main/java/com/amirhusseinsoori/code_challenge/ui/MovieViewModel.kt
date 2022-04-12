package com.amirhusseinsoori.code_challenge.ui

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MovieViewModel @Inject constructor(
    repository: Repository
): ViewModel() {
    val getAllImages = repository.getAllIMovies()
}