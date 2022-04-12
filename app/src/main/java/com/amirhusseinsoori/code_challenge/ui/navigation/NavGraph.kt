package com.amirhusseinsoori.code_challenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.amirhusseinsoori.code_challenge.MovieScreen
import com.amirhusseinsoori.code_challenge.ui.screen.details.DetailsScreen


@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Movie.route
    ) {
        composable(
            route = ScreenRoute.Movie.route,
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) {

            MovieScreen(navController)
        }
        composable(route = ScreenRoute.Details.route) {
            DetailsScreen()
        }
    }
}

