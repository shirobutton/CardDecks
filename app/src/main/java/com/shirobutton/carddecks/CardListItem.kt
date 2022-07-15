package com.shirobutton.carddecks

sealed interface CardListItem {
    val title: String
    val imageUrl: String
    override fun equals(other: Any?): Boolean
}

data class CardTypeA(
    override val title: String,
    override val imageUrl: String
) : CardListItem
