package com.teamj.moneytransferapp.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.UserAPIService
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

                Log.d("Added Fav", "${response.message}")

            } catch (e: Exception) {

                Log.e("addingError", "${e.message}")

            }
        }
    }

    fun getFavorite(favGetReq: FavReq) {
        viewModelScope.launch {


            try {

                val response = UserAPIService.callable.getFav()
                _favoritesList.value = response
                Log.d("Get Fav", "${response}")

            } catch (e: Exception) {

                Log.e("addingError", "${e.message}")

            }
        }
    }

    fun deleteFavorite(favDelReq: FavDelReq) {
        viewModelScope.launch {

            try {

                val response = UserAPIService.callable.deleteFav(favDelReq)

                Log.d("Deleted Fav", "${response.message}")

            } catch (e: Exception) {

                Log.e("addingError", "${e.message}")

            }
        }
    }
}