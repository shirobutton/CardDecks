package com.shirobutton.carddecks

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed interface CardListItem : TitleContainer {
    override fun equals(other: Any?): Boolean
}

data class CardTypeA(
    override val title: String,
    val imageUrl: String
) : CardListItem, StringTitleContainer

data class CardTypeB(
    @StringRes override val titleResId: Int,
    val imageUrl: String
) : CardListItem, StringResourceTitleContainer

data class CardTypeC(
    override val title: String,
    @DrawableRes val imageResId: Int
) : CardListItem, StringTitleContainer

data class CardTypeD(
    @StringRes override val titleResId: Int,
    @DrawableRes val imageResId: Int
) : CardListItem, StringResourceTitleContainer
