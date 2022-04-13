package com.amirhusseinsoori.code_challenge.ui.movie.redux

import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.redux.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieViewState(
    val items:
    Flow<PagingData<MovieEntity>> = emptyFlow(),
    val showProgressBar: Boolean = false
) : State
