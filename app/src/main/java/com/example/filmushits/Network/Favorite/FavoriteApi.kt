package com.example.filmushits.Network.Favorite

import com.example.filmushits.Etities.Models.MovieDetailsModel
import com.example.filmushits.Etities.Models.MovieListModel
import com.example.filmushits.Etities.Models.MoviesPagedListModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoriteApi {
    @GET("/api/favorites")
    suspend fun getFavorite(): MovieListModel

    @POST("/api/favorites/{id}/add")
    suspend fun addFavorite(@Path("id") id: String)

    @POST("/api/favorites/{id}/delete")
    suspend fun deleteFavorite(@Path("id") id: String)
}