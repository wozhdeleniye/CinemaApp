package com.example.filmushits.view.screen.app_screen.FilmScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmushits.Etities.Models.MovieDetailsModel
import com.example.filmushits.Etities.Models.MoviesPagedListModel
import com.example.filmushits.Network.Main.MovieRepository
import com.example.filmushits.Network.Network
import com.example.filmushits.UseCases.GetMovieProfileUseCase
import com.example.filmushits.UseCases.MoviePageListUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class FilmViewModel: ViewModel() {
    fun getDetails(id: String): Deferred<MovieDetailsModel?> {
        return viewModelScope.async {
            val result = GetMovieProfileUseCase(MovieRepository(Network.getInstance().getMovieApi())).invoke(id)
            result.getOrNull()
        }
    }
}