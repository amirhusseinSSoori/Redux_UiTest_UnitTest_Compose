package com.amirhusseinsoori.code_challenge.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsAction
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsEffect
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsReducer
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsViewState
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieAction
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieEffect
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieReducer
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieViewState
import com.amirhusseinsoori.domain.exception.LoadingOccurs
import com.amirhusseinsoori.domain.exception.fold
import com.amirhusseinsoori.domain.redux.LoggingMiddleware
import com.amirhusseinsoori.domain.redux.Store
import com.amirhusseinsoori.domain.useCase.ListMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: ListMovieUseCase
) : ViewModel() {
    private val store = Store(
        initialState = MovieViewState(),
        initialEffect = MovieEffect(),
        reducer = MovieReducer(),
        middlewares = listOf(
            LoggingMiddleware(),
        )
    )
    val viewState: StateFlow<MovieViewState> = store.state

    init {
        event()
    }

    private fun event() {
        viewModelScope.launch {
            store.dispatch(action = MovieAction.ShowAllMovies(useCase.execute()))
        }
    }







}
