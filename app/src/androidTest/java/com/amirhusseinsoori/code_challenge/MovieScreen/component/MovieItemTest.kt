package com.amirhusseinsoori.code_challenge.MovieScreen.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.amirhusseinsoori.code_challenge.ui.movie.screen.component.MovieItems
import com.amirhusseinsoori.domain.entity.MovieEntity
import org.junit.Rule
import org.junit.Test

class MovieItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalCoilApi::class)
    @Test
    fun setTestMovieItem() {
        composeTestRule.setContent {
            val navController: NavHostController = rememberNavController()
            val movieEntity = MovieEntity(
                adult = false,
                backdrop_path = "",
                genre_ids = emptyList(),
                id = 0,
                original_language = "",
                original_title = "",
                overview = "",
                popularity = 0.0,
                poster_path = "",
                release_date = "",
                title = "",
                video = false,
                vote_average = 0.0,
                vote_count = 0

            )
            MovieItems(
                movieEntity,
                navController
            )
        }


    }
}