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

    private val _favorites = MutableStateFlow<List<FavContacts>>(emptyList())
    val favorites = _favorites.asStateFlow()

    fun getFavorites(context: Context) {

        viewModelScope.launch {
            try {

                val userId = SessionController.getUserId(context)
                val addFavorite = UserAPICallable.getFav
                val getFavorite = UserAPIService.getFav()
                val delFavorite = UserAPIService.getFav()

                _favorites.value = response.transactions


            } catch (exception: Exception) {
                Log.e("FavoritesViewModel", "Error fetching favorites: ${exception.message}")
            }

        }

    }
}
