package com.amirhusseinsoori.code_challenge.ui.details.redux

import com.amirhusseinsoori.domain.entity.DetailsEntity
import org.junit.Before
import org.junit.Test

class DetailsReducerTest{
    lateinit var reducer: DetailsReducer

    @Before
    fun init() {
        reducer = DetailsReducer()
    }

    @Test
    fun testReducer_ShowDetailsMovie_State() {
        reducer.reduce(DetailsViewState(DetailsEntity(), true), DetailsAction.ShowDetailsMovie(DetailsEntity()))
    }

    @Test
    fun testReducer_LoadingStarted_State() {
        reducer.reduce(DetailsViewState(DetailsEntity(), true), DetailsAction.LoadingStarted)
    }

    @Test
    fun testReducer_LoadingFinished_State() {
        reducer.reduce(DetailsViewState(DetailsEntity(), true), DetailsAction.LoadingFinished)
    }

    @Test
    fun testReducer_ShowFailed_Effect() {
        reducer.reducer(DetailsEffect("HaveError"), DetailsAction.ShowFailed("HaveError"))
    }


    @Test
    fun testReducer_ShowHide_Effect() {
        reducer.reducer(DetailsEffect("NoError"), DetailsAction.ShowHide("NoError"))
    }


}