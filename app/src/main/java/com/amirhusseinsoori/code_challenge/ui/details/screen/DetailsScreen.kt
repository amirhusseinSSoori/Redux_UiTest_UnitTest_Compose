package com.amirhusseinsoori.code_challenge.ui.details.screen

import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.code_challenge.ui.Loading
import com.amirhusseinsoori.code_challenge.ui.details.DetailsViewModel
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsEffect
import com.amirhusseinsoori.code_challenge.ui.details.screen.component.AllDetails
import com.amirhusseinsoori.common.Constant.NoError


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val context = LocalContext.current
    detailsViewModel.viewState.collectAsState().let {
        it.value.apply {
            Loading(visible = showProgressBar)
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
                Toast.makeText(context, "${it.value.messageError}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



