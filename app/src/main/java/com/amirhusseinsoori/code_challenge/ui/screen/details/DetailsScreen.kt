package com.amirhusseinsoori.code_challenge.ui.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.code_challenge.ui.screen.movie.MovieViewModel
import kotlinx.coroutines.flow.emptyFlow


@Composable
fun DetailsScreen() {
    val homeViewModel: DetailsViewModel = hiltViewModel()

   Column {
       homeViewModel._state.collectAsState().let {
           it.value.data.homepage?.let {
               Text(text = it)
           }

       }
   }


}