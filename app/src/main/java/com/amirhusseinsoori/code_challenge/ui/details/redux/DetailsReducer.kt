package com.amirhusseinsoori.code_challenge.ui.details.redux

import com.amirhusseinsoori.domain.redux.Reducer

class DetailsReducer : Reducer<DetailsViewState, DetailsEffect, DetailsAction> {
    override fun reduce(currentState: DetailsViewState, action: DetailsAction): DetailsViewState {
        return when (action) {
            is DetailsAction.ShowDetailsMovie -> {
                displayMovieList(currentState, action)
            }
            is DetailsAction.Loading -> {
                loadingState(currentState, loading = action.loading)
            }

            else -> currentState
        }
    }

    override fun reducer(currentEffect: DetailsEffect, action: DetailsAction): DetailsEffect {
        return when (action) {
            is DetailsAction.ShowFailed -> {
                stateShowError(currentEffect)
            }
            is DetailsAction.ShowHide -> {
                stateHideError(currentEffect)
            }
            else -> currentEffect
        }
    }


    private fun stateShowError(currentEffect: DetailsEffect) =
        currentEffect.copy(
            messageError = currentEffect.messageError,
        )

    private fun stateHideError(currentEffect: DetailsEffect) =
        currentEffect.copy(
            messageError = "NoError",
        )

    private fun loadingState(currentState: DetailsViewState, loading: Boolean) =
        currentState.copy(
            showProgressBar = loading,
        )

    private fun displayMovieList(
        currentState: DetailsViewState,
        action: DetailsAction.ShowDetailsMovie
    ) = currentState.copy(
        data = action.data,
    )
}