package com.shirobutton.carddecks

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed interface CardListItem : TitleContainer, ImageContainer {
    override fun equals(other: Any?): Boolean
}

data class CardTypeA(
    override val title: String,
    override val imageUrl: String
) : CardListItem, StringTitleContainer, ImageUrlContainer

data class CardTypeB(
    @StringRes override val titleResId: Int,
    override val imageUrl: String
) : CardListItem, StringResourceTitleContainer, ImageUrlContainer

data class CardTypeC(
    override val title: String,
    @DrawableRes override val imageResId: Int
) : CardListItem, StringTitleContainer, ImageResourceContainer

data class CardTypeD(
    @StringRes override val titleResId: Int,
    @DrawableRes override val imageResId: Int
) : CardListItem, StringResourceTitleContainer, ImageResourceContainer
