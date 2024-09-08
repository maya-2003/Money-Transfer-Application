package com.teamj.moneytransferapp.data

import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.model.ProfileInfoItem
import com.teamj.moneytransferapp.model.ProfileItem
import com.teamj.moneytransferapp.navigation.Route

class DataSource {
    fun getProfileItemsList(): List<ProfileItem> {
        val profileItems = mutableListOf<ProfileItem>()
        profileItems.add(
            ProfileItem(
                R.drawable.ic_user,
                R.string.personal_information,
                R.string.personal_information_description,
                Route.PROFILE_INFO
            )
        )
        profileItems.add(
            ProfileItem(
                R.drawable.ic_settings,
                R.string.settings,
                R.string.settings_description
            )
        )
        profileItems.add(
            ProfileItem(
                R.drawable.ic_history,
                R.string.payment_history,
                R.string.payment_history_description
            )
        )
        profileItems.add(
            ProfileItem(
                R.drawable.ic_star,
                R.string.favourite_list,
                R.string.favourite_list_description
            )
        )
        return profileItems
    }


    fun getProfileInfoList(): List<ProfileInfoItem> {
        val profileInfoItems = mutableListOf<ProfileInfoItem>()
        profileInfoItems.add(ProfileInfoItem(R.string.full_name_label, R.string.full_name_value))
        profileInfoItems.add(ProfileInfoItem(R.string.email_label, R.string.email_value))
        profileInfoItems.add(
            ProfileInfoItem(
                R.string.date_of_birth_label,
                R.string.date_of_birth_value
            )
        )
        profileInfoItems.add(ProfileInfoItem(R.string.country_label, R.string.country_value))
        profileInfoItems.add(
            ProfileInfoItem(
                R.string.bank_account_label,
                R.string.bank_account_value
            )
        )

        return profileInfoItems
    }
}