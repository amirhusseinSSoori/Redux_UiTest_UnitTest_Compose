package com.amirhusseinsoori.code_challenge.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.amirhusseinsoori.code_challenge.R
import com.amirhusseinsoori.data.network.response.Movie
import com.amirhusseinsoori.domain.entity.MovieEntity


@ExperimentalCoilApi
@Composable
fun ListContent(items: LazyPagingItems<MovieEntity>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            ) { data ->
            data?.let { MovieItems(movie = it, navController) }
        }

        items.apply {
            when {
                loadState.refresh is LoadState.Loading -> {

                }
                loadState.append is LoadState.Loading -> {

                }
                loadState.refresh is LoadState.Error -> {
                    Log.e("TAG", "ListContent: ")
                }
                loadState.append is LoadState.Error -> {
                    Log.e("TAG", "ListContent: ")
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MovieItems(movie: MovieEntity, navController: NavHostController) {
    val painter =
        rememberImagePainter(data = "https://image.tmdb.org/t/p/w500/${movie.poster_path}") {
            crossfade(durationMillis = 1000)
            error(R.drawable.ic_baseline_error_24)
            placeholder(R.drawable.ic_placeholder)
        }
    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("details_screen/${movie.id}")
            },
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "Movie Image",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black
        ) {}
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = movie.title!!,
                color = Color.White,
                fontSize = MaterialTheme.typography.caption.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}



