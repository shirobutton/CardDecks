package com.shirobutton.carddecks

import androidx.annotation.StringRes

@JvmInline
value class StringResourceId(@StringRes val value: Int)

fun Int.asStringResource() = StringResourceId(this)
