package com.shirobutton.carddecks

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

sealed interface ImageContainer {
    fun into(imageView: ImageView)
}

class ImageUrlContainer(val imageUrl: String) : ImageContainer {
    override fun into(imageView: ImageView) {
        Glide.with(imageView)
            .load(imageUrl)
            .into(imageView)
    }
}

class ImageResourceContainer(@DrawableRes val imageResId: Int) : ImageContainer {
    override fun into(imageView: ImageView) = imageView.setImageResource(imageResId)
}
