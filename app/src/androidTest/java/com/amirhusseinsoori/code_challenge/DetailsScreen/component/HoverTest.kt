package com.amirhusseinsoori.code_challenge.DetailsScreen.component

import androidx.compose.ui.test.junit4.createComposeRule
import com.amirhusseinsoori.code_challenge.ui.details.screen.Hover
import org.junit.Rule
import org.junit.Test

class HoverTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testHover(){
        composeTestRule.setContent {
            Hover()
        }

    }
}