package com.teamj.moneytransferapp.more

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SettingsItem(@StringRes val heading: Int,@StringRes val subHeading: Int, @DrawableRes val icon: Int, val route: String ="")