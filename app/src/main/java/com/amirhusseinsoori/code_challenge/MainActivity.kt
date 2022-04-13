package com.amirhusseinsoori.code_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.code_challenge.ui.movie.MovieViewModel
import com.amirhusseinsoori.code_challenge.ui.movie.redux.MovieAction
import com.amirhusseinsoori.code_challenge.ui.navigation.SetupNavGraph
import com.amirhusseinsoori.code_challenge.ui.theme.Code_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagingApi::class, coil.annotation.ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val movieViewModel: MovieViewModel = hiltViewModel()
            Code_challengeTheme {
                SetupNavGraph(movieViewModel)
            }
        }
    }
}




