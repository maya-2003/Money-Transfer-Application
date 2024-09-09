package com.teamj.moneytransferapp.data

import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.model.Country

class DataSource {
    fun getCountriesList(): List<Country> {
        val countries = mutableListOf<Country>()
        countries.add(Country(R.string.egypt, R.drawable.egypt))
        countries.add(Country(R.string.emirates, R.drawable.emirates))
        countries.add(Country(R.string.qatar, R.drawable.qatar))
        countries.add(Country(R.string.united_states, R.drawable.united_states))
        return countries
    }

}