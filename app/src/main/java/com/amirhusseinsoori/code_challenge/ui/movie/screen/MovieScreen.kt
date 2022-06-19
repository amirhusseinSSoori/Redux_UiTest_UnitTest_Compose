package com.amirhusseinsoori.code_challenge.ui.movie.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.amirhusseinsoori.code_challenge.ui.movie.MovieViewModel
import com.amirhusseinsoori.code_challenge.ui.movie.screen.component.ListMovies


@OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
@Composable
fun MovieScreen(
    navController: NavController,
    viewModel: MovieViewModel,
) {
    ListMovies(
        viewModel,
        navController
    )
}



