package com.example.filmushits.Network.Auth

import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    interface AuthApi {
        @POST("api/account/register")
        suspend fun register(@Body body: RegisterRequestBody): TokenModel

        @POST("api/account/login")
        suspend fun login(@Body body: LoginRequestBody): TokenModel

        @POST("api/account/logout")
        suspend fun logout()
    }
}