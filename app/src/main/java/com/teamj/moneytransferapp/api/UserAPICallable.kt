package com.teamj.moneytransferapp.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

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
}