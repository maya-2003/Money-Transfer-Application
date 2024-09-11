package com.teamj.moneytransferapp.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPICallable
import com.teamj.moneytransferapp.api.UserAPIService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

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