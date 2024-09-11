package com.teamj.moneytransferapp.api

import com.teamj.moneytransferapp.model.FavDelReq
import com.teamj.moneytransferapp.model.FavReq
import com.teamj.moneytransferapp.model.FavResp
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPICallable {
//    @POST("/api/v1/auth/register")
//    @Headers("No-Auth: true")
//    suspend fun registerUser(
//        @Body user: User
//    ): RegisterResponse
//
//    @POST("/api/v1/auth/login")
//    @Headers("No-Auth: true")
//    suspend fun loginUser(
//        @Body loginRequest: UserLogin
//    ): UserLoginResp
//
//    @GET("/api/v1/customer/{customerId}")
//    suspend fun getCustomerById(
//        @Path("customerId") customerId: Int
//    ): UserData
//
//    @PUT("/api/v1/customer/update/{customerId}")
//    suspend fun updateUserInfo(
//        @Path("customerId") customerId: Int,
//        @Body details: UpdatedDetails
//    ): UserData
//
//    @PUT("/api/v1/customer/{customerId}/change-password")
//    suspend fun updateUserPassword(
//        @Path("customerId") customerId: Int,
//        @Body password: Password
//    ): Response<Unit>
//
//    @POST("/api/v1/transactions/transfer")
//    suspend fun transfer(
//        @Body details: Transfer
//    ): TransferResp
//
//    @GET("/api/v1/transactions/history/{accountId}")
//    suspend fun getTransactioHistory(
//        @Path("accountId") customerId: Int
//    ): TransactionRoot

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
