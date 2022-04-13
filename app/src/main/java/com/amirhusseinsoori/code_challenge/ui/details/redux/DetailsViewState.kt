package com.amirhusseinsoori.code_challenge.ui.details.redux

import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.redux.State

data class DetailsViewState(
    val data: DetailsEntity = DetailsEntity(),
    val showProgressBar: Boolean = false
) : State