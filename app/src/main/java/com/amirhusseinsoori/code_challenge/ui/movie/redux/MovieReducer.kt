package com.amirhusseinsoori.code_challenge.ui.movie.redux

import com.amirhusseinsoori.domain.redux.Reducer

class MovieReducer : Reducer<MovieViewState, MovieEffect, MovieAction> {
    override fun reduce(currentState: MovieViewState, action: MovieAction): MovieViewState {
        return when (action) {
            is MovieAction.ShowAllMovies -> {
                displayMovieList(currentState, action)
            }
            is MovieAction.LoadingStarted -> {
                stateAfterLoadingStarted(currentState)
            }
            MovieAction.LoadingFinished -> {
                stateAfterLoadingCompleted(currentState)
            }
            else -> currentState
        }
    }

    override fun reducer(currentEffect: MovieEffect, action: MovieAction): MovieEffect {
        return when (action) {
            is MovieAction.ShowFailed -> {
                stateShowError(currentEffect)
            }
            is MovieAction.ShowHide -> {
                stateHideError(currentEffect)
            }
            else -> currentEffect
        }
    }


     private fun stateShowError(currentEffect: MovieEffect) =
        currentEffect.copy(
            messageError = currentEffect.messageError,
        )

    private fun stateHideError(currentEffect: MovieEffect) =
        currentEffect.copy(
            messageError = "NoError",
        )

    private fun stateAfterLoadingStarted(currentState: MovieViewState) =
        currentState.copy(
            showProgressBar = true,
        )

    private fun stateAfterLoadingCompleted(currentState: MovieViewState) =
        currentState.copy(
            showProgressBar = false,
        )


    private fun displayMovieList(
        currentState: MovieViewState,
        action: MovieAction.ShowAllMovies
    ) = currentState.copy(
        items = action.list,
    )


}