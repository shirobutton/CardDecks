package com.shirobutton.carddecks

import androidx.annotation.StringRes

sealed interface TitleContainer

class StringTitleContainer(val title: String) : TitleContainer

class StringResourceTitleContainer(@StringRes val titleResId: Int) : TitleContainer
