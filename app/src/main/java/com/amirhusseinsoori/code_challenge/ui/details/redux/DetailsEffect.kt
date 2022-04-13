package com.amirhusseinsoori.code_challenge.ui.details.redux

import com.amirhusseinsoori.domain.redux.Effect

data class DetailsEffect  (
    val messageError: String = "NoError"
): Effect