package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.MovieListModel
import com.example.filmushits.Network.Favorite.FavoriteRepository

class GetFavoriteUseCase (
    private val repository: FavoriteRepository
) {
    suspend fun invoke(): Result<MovieListModel> {
        return try {
            Result.success(repository.getFavorite())
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}