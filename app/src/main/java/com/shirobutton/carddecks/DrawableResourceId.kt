package com.shirobutton.carddecks

import androidx.annotation.DrawableRes

@JvmInline
value class DrawableResourceId(@DrawableRes val value: Int)

fun Int.asDrawableResource() = DrawableResourceId(this)
