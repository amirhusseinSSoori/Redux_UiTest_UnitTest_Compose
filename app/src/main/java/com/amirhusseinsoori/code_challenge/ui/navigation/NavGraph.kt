package com.amirhusseinsoori.code_challenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.amirhusseinsoori.code_challenge.ui.details.DetailsViewModel
import com.amirhusseinsoori.code_challenge.ui.details.screen.DetailsScreen
import com.amirhusseinsoori.code_challenge.ui.movie.MovieViewModel
import com.amirhusseinsoori.code_challenge.ui.movie.screen.MovieScreen


@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    val movieViewModel: MovieViewModel = hiltViewModel()

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
            MovieScreen(navController = navController, viewModel = movieViewModel)
        }
        composable(route = ScreenRoute.Details.route) {
            DetailsScreen()
        }
    }
}

