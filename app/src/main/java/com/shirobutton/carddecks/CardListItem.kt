package com.shirobutton.carddecks

import androidx.annotation.StringRes

sealed interface CardListItem {
    val imageUrl: String
    override fun equals(other: Any?): Boolean
}

data class CardTypeA(
    val title: String,
    override val imageUrl: String
) : CardListItem

data class CardTypeB(
    @StringRes val titleResId: Int,
    override val imageUrl: String
) : CardListItem
