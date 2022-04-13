package com.amirhusseinsoori.code_challenge.ui.screen.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.domain.exception.fold
import com.amirhusseinsoori.data.repository.DetailsRepositoryImp
import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.reository.DetailsRepository
import com.amirhusseinsoori.domain.useCase.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val state = MutableStateFlow<State>(State())
    val _state = state.asStateFlow()

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
                        Log.e("TAG", "event:${it.toString()} ")
                        state.value = State(it)
                    },
                    onLoading = {
                        Log.e("TAG", "event: ")
                    },
                    onFailure = {
                        Log.e("TAG", "event:${it.message} ")
                    }
                )
            }
        }


    }
}


data class State(
    val data: DetailsEntity = DetailsEntity()
)