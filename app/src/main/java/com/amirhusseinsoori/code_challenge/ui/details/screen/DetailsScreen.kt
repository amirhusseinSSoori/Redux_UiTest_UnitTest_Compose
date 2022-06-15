package com.amirhusseinsoori.code_challenge.ui.details.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.code_challenge.ui.Loading
import com.amirhusseinsoori.code_challenge.ui.details.DetailsViewModel
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsEffect
import com.amirhusseinsoori.code_challenge.ui.details.screen.component.AllDetails
import com.amirhusseinsoori.code_challenge.ui.theme.black
import com.amirhusseinsoori.common.Constant.NoError


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val context = LocalContext.current
    detailsViewModel.viewState.collectAsState().let {
        it.value.apply {

            Log.e("showProgressBar", "DetailsScreen:${showProgressBar} ")

            if (showProgressBar) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(color = black)
                }
            } else {
                data.apply {
                    AllDetails(
                        url = poster_path.toString(),
                        title = title,
                        language = original_language,
                        budget = budget.toString(),
                        year = release_date,
                        summery = overview
                    )
                }


            }
            detailsViewModel.viewEffect.collectAsState(initial = DetailsEffect()).let {
                if (it.value.messageError != NoError) {
                    Log.e("DetailsScreen", "DetailsScreen:${it.value.messageError} ", )
                    Toast.makeText(context, "${it.value.messageError}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    }



