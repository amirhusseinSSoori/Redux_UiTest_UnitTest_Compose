package com.amirhusseinsoori.code_challenge.ui.navigation

sealed class ScreenRoute(val route: String) {
    object Movie : ScreenRoute("home_screen/{userId}")
    object Details : ScreenRoute("details_screen/{userId}")
}