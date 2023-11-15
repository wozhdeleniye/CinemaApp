package com.example.filmushits.view.screen.app_screen.FavoriteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmushits.Etities.Models.MovieListModel
import com.example.filmushits.Network.Favorite.FavoriteRepository
import com.example.filmushits.Network.Network
import com.example.filmushits.UseCases.AddFavoriteUseCase
import com.example.filmushits.UseCases.DeleteFavoriteUseCase
import com.example.filmushits.UseCases.GetFavoriteUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class FavoriteViewModel: ViewModel() {
    fun getFavorite(): Deferred<MovieListModel?> {
        return viewModelScope.async {
            val result = GetFavoriteUseCase(FavoriteRepository(Network.getInstance().getFavoriteApi())).invoke()
            result.getOrNull()
        }
    }
    fun addFavorite(id: String): Job {
        return viewModelScope.launch {
            val result = AddFavoriteUseCase(FavoriteRepository(Network.getInstance().getFavoriteApi())).invoke(id)
            if (result.isSuccess) { }
            else cancel()
        }
    }

    fun deleteFavorite(id: String): Job {
        return viewModelScope.launch {
            val result = DeleteFavoriteUseCase(FavoriteRepository(Network.getInstance().getFavoriteApi())).invoke(id)
            if (result.isSuccess) { }
            else cancel()
        }
    }

}