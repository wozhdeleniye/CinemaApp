package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.MoviesPagedListModel
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import com.example.filmushits.Network.Main.MovieRepository

class MoviePageListUseCase(
    private val repository: MovieRepository
) {
    suspend fun invoke(page: Int): Result<MoviesPagedListModel> {
        return try {
            Result.success(repository.page(page))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}