package com.teamj.moneytransferapp.api

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserAPIService {
    private lateinit var retrofit: Retrofit


    fun initialize(context: Context, onTokenExpired: suspend () -> Unit) {
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val userPrefs = context.applicationContext.getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val token = userPrefs.getString("auth_token", null)

            val authRequest = chain.request().newBuilder().apply {
                if (token != null) {
                    addHeader("Authorization", "Bearer $token")
                }
            }.build()

            val serverResp = chain.proceed(authRequest)

            if (serverResp.code == 401) {
                SessionController.clearSession(context.applicationContext)

                GlobalScope.launch(Dispatchers.Main) { onTokenExpired() }
            }

            serverResp
        }.build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://sha256-1f39a1226a97.onrender.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val callable: UserAPICallable by lazy {
        retrofit.create(UserAPICallable::class.java)
    }
}