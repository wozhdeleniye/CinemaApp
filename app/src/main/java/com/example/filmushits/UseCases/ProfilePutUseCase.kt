package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Network.Profile.ProfileRepository

class ProfilePutUseCase (
    private val repository: ProfileRepository
) {
    suspend fun invoke(body: ProfileModel) : Result<Unit>{
        return try {
            Result.success(repository.putProfile(body))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}