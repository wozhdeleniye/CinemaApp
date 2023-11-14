package com.example.filmushits.view.screen.app_screen.MainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmushits.Etities.Models.MoviesPagedListModel
import com.example.filmushits.Network.Main.MovieRepository
import com.example.filmushits.Network.Network
import com.example.filmushits.UseCases.MoviePageListUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class MainViewModel: ViewModel() {
    fun getMovies(page: Int): Deferred<MoviesPagedListModel?>{
        return viewModelScope.async {
            val result = MoviePageListUseCase(MovieRepository(Network.getInstance().getMovieApi())).invoke(page)
            result.getOrNull()
        }
    }
}