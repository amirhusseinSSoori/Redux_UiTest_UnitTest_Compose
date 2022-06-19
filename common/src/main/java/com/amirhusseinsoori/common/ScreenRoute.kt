package com.amirhusseinsoori.common

sealed class ScreenRoute(val route: String) {
    object Intro : ScreenRoute("intro_screen")
    object Movie : ScreenRoute("movie_screen")
    object Details : ScreenRoute("details_screen")
}