package com.shirobutton.carddecks

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed interface CardListItem {
    override fun equals(other: Any?): Boolean
}

data class CardTypeA(
    val title: String,
    val imageUrl: String
) : CardListItem

data class CardTypeB(
    @StringRes val titleResId: Int,
    val imageUrl: String
) : CardListItem

data class CardTypeC(
    val title: String,
    @DrawableRes val imageResId: Int
) : CardListItem

data class CardTypeD(
    @StringRes val titleResId: Int,
    @DrawableRes val imageResId: Int
) : CardListItem
