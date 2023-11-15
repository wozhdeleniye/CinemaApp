package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.Network.Auth.AuthRepository

class LogOutUseCase(
    private val repository: AuthRepository
) {
    suspend fun invoke(): Result<Unit> {
        return try {
            Result.success(repository.logout())
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}