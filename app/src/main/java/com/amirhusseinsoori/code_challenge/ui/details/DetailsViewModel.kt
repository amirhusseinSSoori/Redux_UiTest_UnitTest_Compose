package com.amirhusseinsoori.code_challenge.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsAction
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsEffect
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsReducer
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsViewState
import com.amirhusseinsoori.common.Constant.NoError
import com.amirhusseinsoori.domain.exception.LoadingOccurs
import com.amirhusseinsoori.domain.exception.fold
import com.amirhusseinsoori.domain.redux.LoggingMiddleware
import com.amirhusseinsoori.domain.redux.Store
import com.amirhusseinsoori.domain.useCase.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val store = Store(
        initialState = DetailsViewState(),
        initialEffect = DetailsEffect(),
        reducer = DetailsReducer(),
        middlewares = listOf(
            LoggingMiddleware(),
        )
    )
    val viewState: StateFlow<DetailsViewState> = store.state
    val viewEffect: Flow<DetailsEffect> = store.effect

    init {
        savedStateHandle.get<String>("userId")?.let { id ->
            event(id.toInt())
        }
    }

    fun event(id: Int) {
        viewModelScope.launch {
            detailsUseCase.execute(id).collect { it ->
                it.fold(
                    onSuccess = {
                        store.effect(DetailsAction.ShowHide(NoError)) { DetailsEffect(NoError) }
                        store.dispatch(action = DetailsAction.ShowDetailsMovie(it))
                    },
                    onLoading = {
                        when (it) {
                            LoadingOccurs.StartLoading -> {
                                store.dispatch(action = DetailsAction.LoadingStarted)
                            }
                            LoadingOccurs.FinishLoading -> {
                                store.dispatch(action = DetailsAction.LoadingFinished)
                            }
                        }
                    },
                    onFailure = {
                        store.effect(DetailsAction.ShowFailed(it.message!!)) { DetailsEffect(it.message!!) }
                    }
                )
            }
        }


    }
}
