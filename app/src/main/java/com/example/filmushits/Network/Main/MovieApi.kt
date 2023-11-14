package com.example.filmushits.Network.Main

import com.example.filmushits.Etities.Models.MoviesPagedListModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MovieApi {
    @GET("api/movie/")
    suspend fun page(@Body body: Int): MoviesPagedListModel
}