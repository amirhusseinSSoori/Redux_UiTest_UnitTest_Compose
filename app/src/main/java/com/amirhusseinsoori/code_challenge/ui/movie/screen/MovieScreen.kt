package com.amirhusseinsoori.code_challenge.ui.movie.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.amirhusseinsoori.code_challenge.ui.movie.MovieViewModel
import com.amirhusseinsoori.code_challenge.ui.movie.screen.component.ListMovies


@OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
@Composable
fun MovieScreen(
    navController: NavHostController,
    viewModel: MovieViewModel,
) {
    ListMovies(
        viewModel
      ,
        navController
    )
}



