package com.amirhusseinsoori.code_challenge.ui.movie


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieAction
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieEffect
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieReducer
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieViewState
import com.amirhusseinsoori.domain.redux.LoggingMiddleware
import com.amirhusseinsoori.domain.redux.Store
import com.amirhusseinsoori.domain.useCase.ListMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
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

    fun event() {
        viewModelScope.launch {
            store.dispatch(
                action = MovieAction.ShowAllMovies(
                    useCase.execute().cachedIn(viewModelScope)
                )
            )
        }
    }


}
