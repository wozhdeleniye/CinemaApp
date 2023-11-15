package com.example.filmushits.Network.Favorite

import com.example.filmushits.Etities.Models.MovieListModel
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Network.Profile.ProfileApi

class FavoriteRepository (
    private val api: FavoriteApi
) {
    suspend fun getFavorite(): MovieListModel {
        return api.getFavorite()
    }
    suspend fun addFavorite(id: String) {
        return api.addFavorite(id)
    }
    suspend fun deleteFavorite(id: String) {
        return api.deleteFavorite(id)
    }
}