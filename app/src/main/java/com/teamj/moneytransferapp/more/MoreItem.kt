package com.teamj.moneytransferapp.more

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MoreItem(@StringRes val text: Int, @DrawableRes val icon: Int, val route: String ="")
