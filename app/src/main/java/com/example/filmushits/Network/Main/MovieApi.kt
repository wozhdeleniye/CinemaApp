package com.example.filmushits.Network.Main

import com.example.filmushits.Etities.Models.MovieDetailsModel
import com.example.filmushits.Etities.Models.MoviesPagedListModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieApi {
    @GET("/api/movies/{page}")
    suspend fun page(@Path("page") page: Int): MoviesPagedListModel
    @GET("/api/movies/details/{id}")
    suspend fun detailed(@Path("id") id: String): MovieDetailsModel
}