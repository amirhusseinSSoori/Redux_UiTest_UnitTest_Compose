package com.amirhusseinsoori.code_challenge.DetailsScreen.component

import androidx.compose.ui.test.junit4.createComposeRule
import com.amirhusseinsoori.code_challenge.ui.details.screen.component.BackGroundImage
import org.junit.Rule
import org.junit.Test

class BackGroundTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBackGround(){
        composeTestRule.setContent {
            BackGroundImage("empty")
        }

    }
}