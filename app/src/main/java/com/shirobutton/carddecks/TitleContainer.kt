package com.shirobutton.carddecks

import androidx.annotation.StringRes

sealed interface TitleContainer

sealed interface StringTitleContainer : TitleContainer {
    val title: String
}

sealed interface StringResourceTitleContainer : TitleContainer {
    @get:StringRes
    val titleResId: Int
}
