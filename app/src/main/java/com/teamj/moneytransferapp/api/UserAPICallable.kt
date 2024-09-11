package com.teamj.moneytransferapp.api

import com.teamj.moneytransferapp.api.model.Password
import com.teamj.moneytransferapp.api.model.RegisterResponse
import com.teamj.moneytransferapp.api.model.Transaction
import com.teamj.moneytransferapp.api.model.Transfer
import com.teamj.moneytransferapp.api.model.TransferResp
import com.teamj.moneytransferapp.api.model.UpdatedDetails
import com.teamj.moneytransferapp.api.model.User
import com.teamj.moneytransferapp.api.model.UserData
import com.teamj.moneytransferapp.api.model.UserLogin
import com.teamj.moneytransferapp.api.model.UserLoginResp
import com.teamj.moneytransferapp.model.FavDelReq
import com.teamj.moneytransferapp.model.FavReq
import com.teamj.moneytransferapp.model.FavResp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserAPICallable {
    @POST("/api/v1/auth/register")
    @Headers("No-Auth: true")
    suspend fun registerUser(
        @Body user: User
    ): RegisterResponse

    @POST("/api/v1/auth/login")
    @Headers("No-Auth: true")
    suspend fun loginUser(
        @Body loginRequest: UserLogin
    ): UserLoginResp

    @GET("/api/v1/customer/{customerId}")
    suspend fun getCustomerById(
        @Path("customerId") customerId: Int
    ): UserData

    @PUT("/api/v1/customer/update/{customerId}")
    suspend fun updateUserInfo(
        @Path("customerId") customerId: Int,
        @Body details: UpdatedDetails
    ): UserData

    @PUT("/api/v1/customer/{customerId}/change-password")
    suspend fun updateUserPassword(
        @Path("customerId") customerId: Int,
        @Body password: Password
    ): Response<Unit>

    @POST("/api/v1/transactions/transfer")
    suspend fun transfer(
        @Body details: Transfer
    ): TransferResp

    @GET("/api/v1/transactions/history/{accountId}")
    suspend fun getTransactioHistory(
        @Path("accountId") accountId: Int
    ): List<Transaction>

    @POST("/api/v1/favorites/add")
    suspend fun addFav(
        @Body details: FavReq
    ): FavResp

    @GET("/api/v1/favorites")
    suspend fun getFav(
    ): List<FavReq>

    @DELETE("/api/v1/favorites/delete")
    suspend fun deleteFav(
        @Body details: FavDelReq
    ): FavResp

}