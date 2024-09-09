package com.teamj.moneytransferapp.more

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProfileItem(@DrawableRes val icon:Int, @StringRes val title:Int, @StringRes val description:Int, val destination: String ="")
