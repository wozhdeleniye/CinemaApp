package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import com.example.filmushits.Network.Auth.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend fun invoke(body: RegisterRequestBody): Result<TokenModel> {
        return try {
            Result.success(repository.register(body))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}