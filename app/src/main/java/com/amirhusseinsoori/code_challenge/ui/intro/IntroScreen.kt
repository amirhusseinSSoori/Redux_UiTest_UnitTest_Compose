package com.amirhusseinsoori.code_challenge.ui.intro

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.amirhusseinsoori.code_challenge.ui.Loader
import com.amirhusseinsoori.code_challenge.ui.navigation.ScreenRoute
import com.amirhusseinsoori.code_challenge.ui.theme.black
import com.amirhusseinsoori.code_challenge.ui.theme.white
import com.amirhusseinsoori.code_challenge.ui.utilFont
import kotlinx.coroutines.delay
import com.amirhusseinsoori.code_challenge.R


@Composable
fun Intro(navController: NavHostController) {
    val scale = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(ScreenRoute.Movie.route){
            popUpTo(ScreenRoute.Intro.route) { inclusive = true }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Loader(R.raw.cinema)
        Text(
            text = stringResource(id = R.string.intro), color = white, fontFamily = utilFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

    }

}
