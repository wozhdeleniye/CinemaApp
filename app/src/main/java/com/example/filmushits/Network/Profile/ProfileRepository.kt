package com.example.filmushits.Network.Profile

import com.example.filmushits.Etities.Models.MoviesPagedListModel
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Network.Main.MovieApi

class ProfileRepository (
    private val api: ProfileApi
) {
    suspend fun getProfile(): ProfileModel {
        return api.getProfile()
    }
    suspend fun putProfile(body: ProfileModel) {
        return api.putProfile(body)
    }
}