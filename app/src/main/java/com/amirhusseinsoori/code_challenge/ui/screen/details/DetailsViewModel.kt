package com.amirhusseinsoori.code_challenge.ui.screen.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.data.exception.fold
import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.data.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val repository: DetailsRepository) : ViewModel() {
    val state = MutableStateFlow<State>(State())

    init {
        event()
    }

    fun event() {
        viewModelScope.launch {
            repository.getDetailsRepository().collect {
                it.fold(
                    onSuccess = {
                        Log.e("TAG", "event:${it.toString()} ")
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
    val data: Details = Details()
)