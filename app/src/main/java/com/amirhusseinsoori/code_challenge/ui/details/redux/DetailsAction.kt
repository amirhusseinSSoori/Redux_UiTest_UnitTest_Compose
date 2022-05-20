package com.amirhusseinsoori.code_challenge.ui.details.redux

import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.redux.Action

sealed class DetailsAction :Action{
    data class ShowDetailsMovie(val data: DetailsEntity) : DetailsAction()
    data class Loading(val loading:Boolean): DetailsAction()
    data class ShowFailed(val errorMessage: String) : DetailsAction()
    data class ShowHide(val errorMessage: String) : DetailsAction()
}