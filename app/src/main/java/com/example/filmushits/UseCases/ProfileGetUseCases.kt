package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Network.Profile.ProfileRepository

class ProfileGetUseCases (
    private val repository: ProfileRepository
) {
    suspend fun invoke(): Result<ProfileModel> {
        return try {
            Result.success(repository.getProfile())
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}