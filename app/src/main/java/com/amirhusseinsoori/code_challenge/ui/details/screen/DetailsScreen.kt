package com.amirhusseinsoori.code_challenge.ui.details.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.amirhusseinsoori.code_challenge.R
import com.amirhusseinsoori.code_challenge.ui.details.DetailsViewModel
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsEffect
import com.amirhusseinsoori.code_challenge.ui.details.screen.component.AllDetails
import com.amirhusseinsoori.code_challenge.ui.theme.black
import com.amirhusseinsoori.code_challenge.ui.utilFont
import com.amirhusseinsoori.common.Constant.NoError


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val context = LocalContext.current
    detailsViewModel.viewState.collectAsState().let {
        it.value.data.apply {
            AllDetails(
                url = poster_path.toString(),
                title = title,
                language = original_language,
                budget = budget.toString(),
                year = release_date,
                summery = overview
            )
        }

        detailsViewModel.viewEffect.collectAsState(initial = DetailsEffect()).let {
            if (it.value.messageError != NoError) {
                Toast.makeText(context, "${it.value.messageError}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


