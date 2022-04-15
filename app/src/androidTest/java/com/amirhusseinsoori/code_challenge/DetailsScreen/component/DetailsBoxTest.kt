package com.amirhusseinsoori.code_challenge.DetailsScreen.component

import androidx.compose.ui.test.junit4.createComposeRule
import com.amirhusseinsoori.code_challenge.ui.details.screen.DetailsBox
import com.amirhusseinsoori.code_challenge.ui.details.screen.Hover
import org.junit.Rule
import org.junit.Test

class DetailsBoxTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testDetailsBox(){
        composeTestRule.setContent {
            DetailsBox("fn")
        }

    }
}