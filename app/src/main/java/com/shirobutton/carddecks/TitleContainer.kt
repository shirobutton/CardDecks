package com.shirobutton.carddecks

import android.content.Context
import androidx.annotation.StringRes

sealed interface TitleContainer {
    fun getString(context: Context): String
}

class StringTitleContainer(val title: String) : TitleContainer {
    override fun getString(context: Context) = title
}

class StringResourceTitleContainer(@StringRes val titleResId: Int) : TitleContainer {
    override fun getString(context: Context) = context.getString(titleResId)
}
