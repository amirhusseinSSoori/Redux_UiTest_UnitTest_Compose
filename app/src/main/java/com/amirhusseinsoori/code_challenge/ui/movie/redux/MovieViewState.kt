package com.amirhusseinsoori.code_challenge.ui.movie.redux

import androidx.paging.compose.LazyPagingItems
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.redux.State

data class MovieViewState(
    val items: LazyPagingItems<MovieEntity>? = null,
    val showProgressBar: Boolean = false
) : State
