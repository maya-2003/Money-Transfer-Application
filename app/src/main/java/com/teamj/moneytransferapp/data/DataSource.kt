package com.teamj.moneytransferapp.data

import com.maya.moneytransferapp.Transaction
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.more.Country
import com.teamj.moneytransferapp.more.MoreItem
import com.teamj.moneytransferapp.more.ProfileInfoItem
import com.teamj.moneytransferapp.more.ProfileItem
import com.teamj.moneytransferapp.more.SettingsItem
import com.teamj.moneytransferapp.navigation.Route

class DataSource {
    fun getCountryList(): List<Country> {
        val countries = mutableListOf<Country>()
        countries.add(Country(R.string.egypt, R.drawable.egypt))
        countries.add(Country(R.string.emirates, R.drawable.emirates))
        countries.add(Country(R.string.qatar, R.drawable.qatar))
        countries.add(Country(R.string.united_states, R.drawable.united_states))
        return countries
    }
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
                R.string.settings_description,
                Route.SETTINGS
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

    fun getProfileInfoItem(): List<ProfileInfoItem> {
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
    fun getMoreOptions(): List<MoreItem> {
        val options = mutableListOf<MoreItem>()
        options.add(MoreItem(R.string.transfer, R.drawable.ic_website))
        options.add(MoreItem(R.string.favourites, R.drawable.ic_star))
        options.add(MoreItem(R.string.profile, R.drawable.ic_user, Route.PROFILE))
        options.add(MoreItem(R.string.help, R.drawable.ic_error))
        options.add(MoreItem(R.string.logout, R.drawable.ic_logout))
        return options
    }

    fun getSettings(): List<SettingsItem> {
        val settings = mutableListOf<SettingsItem>()
        settings.add(SettingsItem(R.string.change_password, R.string.change_password, R.drawable.ic_lock, Route.CHANGE_PASSWORD))
        settings.add(SettingsItem(R.string.edit_profile, R.string.change_info, R.drawable.ic_edit, Route.EDIT_PROFILE))
        return settings
    }

    fun getTransactions(): List<Transaction> {
        val transactions = mutableListOf<Transaction>()
        transactions.add(Transaction("Ahmed Mohamed", "Visa", "1234", "Today 11:00", "500 EGP"))
        transactions.add(Transaction("Ahmed Mohamed", "Visa", "1234", "Today 11:00", "500 EGP"))
        transactions.add(Transaction("Ahmed Mohamed", "Visa", "1234", "Today 11:00", "500 EGP"))
        return transactions
    }
}