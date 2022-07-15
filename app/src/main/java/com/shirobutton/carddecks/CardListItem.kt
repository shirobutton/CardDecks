package com.shirobutton.carddecks

data class CardListItem(
    private val titleContainer: TitleContainer,
    private val imageContainer: ImageContainer
) : TitleContainer by titleContainer, ImageContainer by imageContainer
