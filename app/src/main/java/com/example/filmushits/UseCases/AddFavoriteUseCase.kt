package com.example.filmushits.UseCases

import com.example.filmushits.Network.Favorite.FavoriteRepository

class AddFavoriteUseCase (
    private val repository: FavoriteRepository
) {
    suspend fun invoke(id: String) : Result<Unit>{
        return try {
            Result.success(repository.addFavorite(id))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}