package com.amirhusseinsoori.code_challenge

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amirhusseinsoori.code_challenge.ui.details.screen.DetailsScreen
import com.amirhusseinsoori.code_challenge.ui.intro.Intro
import com.amirhusseinsoori.code_challenge.ui.movie.MovieViewModel
import com.amirhusseinsoori.code_challenge.ui.movie.screen.MovieScreen
import com.amirhusseinsoori.code_challenge.ui.navigation.SetupNavGraph
import com.amirhusseinsoori.code_challenge.ui.theme.Code_challengeTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity


    @OptIn(ExperimentalPagingApi::class)
    @Before
    fun init() {

        composeTestRule.activityRule.scenario.onActivity {
            activity = it
        }
    }

    @OptIn(ExperimentalPagingApi::class, coil.annotation.ExperimentalCoilApi::class)
    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    @Test
    fun activityTest() {
        composeTestRule.setContent {
            Code_challengeTheme {
                SetupNavGraph()
            }
        }


    }

    @Test
    fun detailsTest() {
        composeTestRule.setContent {
            Code_challengeTheme {
                DetailsScreen()
            }
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun movieTest() {
        composeTestRule.setContent {
            Code_challengeTheme {
                val navController: NavHostController = rememberNavController()
                val viewModel: MovieViewModel = hiltViewModel()
                MovieScreen(navController, viewModel = viewModel)
            }
        }
    }



    @Test
    fun introTest() {
        composeTestRule.setContent {
            Code_challengeTheme {
                val navController: NavHostController = rememberNavController()
                Intro(navController)
            }
        }
    }

}
