package com.amirhusseinsoori.code_challenge.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun DetailsScreen() {
    val homeViewModel: DetailsViewModel = hiltViewModel()

   Column {
       homeViewModel._state.collectAsState().let {
           it.value.data.original_language?.let {
               Text(text = it)
           }

       }
   }


}