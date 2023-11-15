package com.example.filmushits.UseCases

import com.example.filmushits.Etities.Models.MovieDetailsModel
import com.example.filmushits.Etities.Models.MoviesPagedListModel
import com.example.filmushits.Network.Main.MovieRepository

class GetMovieProfileUseCase (
    private val repository: MovieRepository
) {
    suspend fun invoke(id: String): Result<MovieDetailsModel> {
        return try {
            Result.success(repository.detailed(id))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }
}