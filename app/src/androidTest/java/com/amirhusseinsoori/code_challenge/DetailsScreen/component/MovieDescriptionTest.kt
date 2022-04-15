package com.amirhusseinsoori.code_challenge.DetailsScreen.component

import androidx.compose.ui.test.junit4.createComposeRule
import com.amirhusseinsoori.code_challenge.ui.details.screen.component.MovieDescription
import org.junit.Rule
import org.junit.Test

class MovieDescriptionTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMovieDescription(){
        composeTestRule.setContent {
            MovieDescription(
                dsTitle="home",
                language="en",
                budget="100000",
                dsYear="1997",
                dsSummery=""
            )
        }

    }
}