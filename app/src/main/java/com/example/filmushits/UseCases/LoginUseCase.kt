package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import com.example.filmushits.Network.Auth.AuthRepository

class LoginUseCase( private val repository: AuthRepository
) {
    suspend fun invoke(body: LoginRequestBody): Result<TokenModel> {
        return try {
            Result.success(repository.login(body))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}