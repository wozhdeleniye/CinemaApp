package com.example.filmushits.Network.Auth

import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody

class AuthRepository(
    private val api: AuthApi.AuthApi
) {
    suspend fun register(body: RegisterRequestBody): TokenModel {
        return api.register(body)
    }

    suspend fun login(body: LoginRequestBody): TokenModel {
        return api.login(body)
    }

    suspend fun logout() {
        api.logout()
    }
}