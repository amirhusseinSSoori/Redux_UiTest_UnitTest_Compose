package com.amirhusseinsoori.code_challenge.ui.movie.redux

import androidx.paging.compose.LazyPagingItems
import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.redux.Action

sealed class MovieAction:Action {
    data class ShowAllMovies(val list: LazyPagingItems<MovieEntity>) : MovieAction()
    object LoadingStarted : MovieAction()
    object LoadingFinished : MovieAction()
    data class ShowFailed(val errorMessage: String) : MovieAction()
    data class ShowHide(val errorMessage: String) : MovieAction()
}