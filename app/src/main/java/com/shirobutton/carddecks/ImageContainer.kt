package com.shirobutton.carddecks

import androidx.annotation.DrawableRes

sealed interface ImageContainer

class ImageUrlContainer(val imageUrl: String) : ImageContainer

class ImageResourceContainer(@DrawableRes val imageResId: Int) : ImageContainer
