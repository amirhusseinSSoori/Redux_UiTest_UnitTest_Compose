package com.amirhusseinsoori.code_challenge.ui.movie.redux

import kotlinx.coroutines.flow.emptyFlow
import org.junit.Before
import org.junit.Test

class MovieReducerTest {

    lateinit var reducer: MovieReducer

    @Before
    fun init() {
        reducer = MovieReducer()
    }

    @Test
    fun testReducer_ShowAllMovies_State() {
        reducer.reduce(MovieViewState(emptyFlow(), true), MovieAction.ShowAllMovies(emptyFlow()))
    }

    @Test
    fun testReducer_LoadingStarted_State() {
        reducer.reduce(MovieViewState(emptyFlow(), true), MovieAction.LoadingStarted)
    }

    @Test
    fun testReducer_LoadingFinished_State() {
        reducer.reduce(MovieViewState(emptyFlow(), true), MovieAction.LoadingFinished)
    }

    @Test
    fun testReducer_ShowFailed_Effect() {
        reducer.reducer(MovieEffect("HaveError"), MovieAction.ShowFailed("HaveError"))
    }


    @Test
    fun testReducer_ShowHide_Effect() {
        reducer.reducer(MovieEffect("NoError"), MovieAction.ShowHide("NoError"))
    }

}
