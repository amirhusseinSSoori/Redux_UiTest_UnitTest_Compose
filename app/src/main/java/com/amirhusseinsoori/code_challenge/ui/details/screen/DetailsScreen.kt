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


@Composable
fun AllDetails(
    url: String,
    title: String,
    language: String,
    budget: String,
    year: String,
    summery: String
) {
    BackGroundImage(url)
    Hover()
    MovieDescription(title, language, budget, year, summery)
}


@Composable
fun MovieDescription(
    dsTitle: String,
    language: String,
    budget: String,
    dsYear: String,
    dsSummery: String
) {
    val scroll = rememberScrollState(0)
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
    ) {
        val (title, topicCast, cast, director, topicYearDirector, topicSummery, summery) = createRefs()


        //  Title
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(
                    start =
                    5.dp, end = 5.dp, top = 5.dp
                )
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 15.dp)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
            elevation = 10.dp,
            backgroundColor = Color(0x73F8F6F6),
        ) {
            DetailsBox(language = dsTitle)

        }

        // Cast
        Text(
            text = stringResource(id = R.string.language), color = Color(0xA3F3F1F1),
            modifier = Modifier
                .constrainAs(topicCast) {
                    top.linkTo(title.bottom, margin = 5.dp)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth(),
            fontFamily = utilFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,

            )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(
                    start =
                    5.dp, end = 5.dp, top = 5.dp
                )
                .constrainAs(cast) {
                    top.linkTo(topicCast.bottom, margin = 5.dp)
                    end.linkTo(parent.end, margin = 5.dp)
                    start.linkTo(parent.start, margin = 5.dp)
                },
            elevation = 10.dp,
            backgroundColor = Color(0x73F8F6F6),
        ) {
            DetailsBox(language = language)

        }
        //Director


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topicYearDirector) {
                    top.linkTo(cast.bottom, margin = 5.dp)
                    start.linkTo(parent.start)
                },
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.budget),
                color = Color(0x73F8F6F6),
                fontFamily = utilFont,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = stringResource(id = R.string.Year),
                color = Color(0x73F8F6F6),
                fontFamily = utilFont,
                fontWeight = FontWeight.Normal
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(director) {
                    top.linkTo(topicYearDirector.bottom)
                    end.linkTo(parent.end, margin = 5.dp)
                    start.linkTo(parent.start, margin = 5.dp)
                },
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp)
                    .padding(
                        start =
                        5.dp, top = 5.dp
                    ),
                elevation = 10.dp,
                backgroundColor = Color(0x73F8F6F6),
            ) {
                DetailsBox(language = budget)

            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp)
                    .padding(
                        start =
                        5.dp, top = 5.dp
                    ),
                elevation = 10.dp,
                backgroundColor = Color(0x73F8F6F6),
            ) {
                DetailsBox(language = dsYear)
            }
        }
        // Summery
        Text(
            text = stringResource(id = R.string.summery),
            color = Color(0xA3F3F1F1),
            modifier = Modifier
                .constrainAs(topicSummery) {
                    top.linkTo(director.bottom, margin = 5.dp)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth(),
            fontFamily = utilFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start =
                    5.dp, end = 5.dp, top = 5.dp
                )
                .constrainAs(summery) {
                    top.linkTo(topicSummery.bottom, margin = 5.dp)
                    end.linkTo(parent.end, margin = 5.dp)
                    start.linkTo(parent.start, margin = 5.dp)
                },
            elevation = 10.dp,
            backgroundColor = Color(0x73F8F6F6),
        ) {
            DetailsBox(dsSummery)
        }


    }


}

@Composable
fun DetailsBox(language: String) {
    Box(contentAlignment = Alignment.Center) {
        Text(
            text = language, color = black, fontFamily = utilFont,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun Hover() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xBF020202))
    ) {}
}

@Composable
fun BackGroundImage(uri: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        val painter =
            rememberImagePainter(data = "https://image.tmdb.org/t/p/w500/${uri}") {
                crossfade(durationMillis = 1000)
                error(R.drawable.ic_baseline_error_24)
                placeholder(R.drawable.ic_placeholder)
            }

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "Movie Image",
            contentScale = ContentScale.Crop
        )

    }


}