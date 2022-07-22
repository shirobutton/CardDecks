package com.shirobutton.carddecks

import androidx.annotation.DrawableRes

sealed interface ImageContainer

sealed interface ImageUrlContainer : ImageContainer {
    val imageUrl: String
}

sealed interface ImageResourceContainer : ImageContainer {
    @get:DrawableRes val imageResId: Int
}
