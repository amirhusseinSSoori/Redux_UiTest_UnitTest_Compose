package com.amirhusseinsoori.code_challenge.ui.navigation

sealed class ScreenRoute(val route: String) {
    object Intro : ScreenRoute("intro_screen")
    object Movie : ScreenRoute("movie_screen")
    object Details : ScreenRoute("details_screen")
}