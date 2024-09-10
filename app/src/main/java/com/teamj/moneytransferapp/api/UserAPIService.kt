package com.teamj.moneytransferapp.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserAPIService {
    private lateinit var retrofit: Retrofit


    fun initialize(context: Context) {
        val client = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val token = editor.getString("auth_token", null)

            val authRequest = chain.request().newBuilder().apply {
                if (token != null) {
                    addHeader("Authorization", "Bearer $token")
                }
            }.build()

            chain.proceed(authRequest)
        }).build()

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