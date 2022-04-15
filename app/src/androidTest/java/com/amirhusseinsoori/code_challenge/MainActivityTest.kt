package com.amirhusseinsoori.code_challenge

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.paging.ExperimentalPagingApi
import androidx.test.ext.junit.runners.AndroidJUnit4
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
  fun detailsLoadingTest() {
    composeTestRule.setContent {
      Code_challengeTheme {
        SetupNavGraph()
      }
    }


  }


}
