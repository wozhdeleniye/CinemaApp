package com.example.filmushits.Network.Profile

import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.Models.TokenModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface ProfileApi {
    @GET("api/account/profile")
    suspend fun getProfile(): ProfileModel

    @PUT("/api/account/profile")
    suspend fun putProfile(@Body body: ProfileModel)
}