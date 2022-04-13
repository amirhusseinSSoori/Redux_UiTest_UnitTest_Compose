package com.amirhusseinsoori.code_challenge.ui.details.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.code_challenge.ui.details.DetailsViewModel
import com.amirhusseinsoori.code_challenge.ui.details.redux.DetailsEffect


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val context = LocalContext.current
    Column {
        detailsViewModel.viewState.collectAsState().let {
            it.value.data.apply {
                Text(text = title)
                Log.e("TAG", "DetailsScreen:${title} ")
            }
        }
        detailsViewModel.viewEffect.collectAsState(initial = DetailsEffect()).let {
            if (it.value.messageError != "NoError") {
                Toast.makeText(context, "${it.value.messageError}", Toast.LENGTH_SHORT).show()
            }
        }
    }


}