package com.amirhusseinsoori.code_challenge.ui.movie.redux

import androidx.paging.PagingData
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.redux.Action
import kotlinx.coroutines.flow.Flow

sealed class MovieAction:Action {
    data class ShowAllMovies(val list:
                             Flow<PagingData<MovieEntity>>
    ) : MovieAction()
    object LoadingStarted : MovieAction()
    object LoadingFinished : MovieAction()
    data class ShowFailed(val errorMessage: String) : MovieAction()
    data class ShowHide(val errorMessage: String) : MovieAction()
}