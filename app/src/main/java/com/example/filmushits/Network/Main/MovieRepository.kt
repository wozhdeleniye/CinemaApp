package com.example.filmushits.Network.Main

import com.example.filmushits.Etities.Models.MoviesPagedListModel

class MovieRepository(
    private val api: MovieApi
) {
    suspend fun page(body: Int): MoviesPagedListModel {
        return api.page(body)
    }
}