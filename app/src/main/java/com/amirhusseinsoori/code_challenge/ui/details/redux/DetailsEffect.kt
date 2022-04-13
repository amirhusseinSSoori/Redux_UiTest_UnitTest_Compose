package com.amirhusseinsoori.code_challenge.ui.details.redux

import com.amirhusseinsoori.common.Constant
import com.amirhusseinsoori.domain.redux.Effect

data class DetailsEffect  (
    val messageError: String = Constant.NoError
): Effect