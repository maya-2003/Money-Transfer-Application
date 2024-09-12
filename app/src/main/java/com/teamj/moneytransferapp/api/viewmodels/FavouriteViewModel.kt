package com.teamj.moneytransferapp.api.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.favorites.FavDelReq
import com.teamj.moneytransferapp.favorites.FavReq
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class FavoritesViewModel : ViewModel() {

    private val _favoritesList = MutableStateFlow<List<FavReq>>(emptyList())
    val favoritesList = _favoritesList.asStateFlow()

    fun addFavorite(favReq: FavReq) {
        viewModelScope.launch {

            try {

                val response = UserAPIService.callable.addFav(favReq)

                Log.d("favourite", "${response.message}")

            } catch (e: Exception) {

                Log.e("error", "${e.message}")

            }
        }
    }

    fun getFavorite() {
        viewModelScope.launch {


            try {

                val fav = UserAPIService.callable.getFav()
                _favoritesList.value = fav
                Log.d("fsvourite", "${fav}")

            } catch (e: Exception) {

                Log.e("error", "${e.message}")

            }
        }
    }

    fun deleteFavorite(favDelReq: FavDelReq) {
        viewModelScope.launch {

            try {

                val fav = UserAPIService.callable.deleteFav(favDelReq)

                Log.d("fav", "${fav.message}")

            } catch (e: Exception) {

                Log.e("error", "${e.message}")

            }
        }
    }
}