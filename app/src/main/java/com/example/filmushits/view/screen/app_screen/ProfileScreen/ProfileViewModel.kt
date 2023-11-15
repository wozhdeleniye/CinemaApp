package com.example.filmushits.view.screen.app_screen.ProfileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Network.Auth.AuthRepository
import com.example.filmushits.Network.Network
import com.example.filmushits.Network.Profile.ProfileRepository
import com.example.filmushits.UseCases.LogOutUseCase
import com.example.filmushits.UseCases.ProfileGetUseCase
import com.example.filmushits.UseCases.ProfilePutUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel(){
    fun getProfile(): Deferred<ProfileModel?> {
        return viewModelScope.async {
            val result = ProfileGetUseCase(ProfileRepository(Network.getInstance().getProfileApi())).invoke()
            result.getOrNull()
        }
    }

    fun putProfile(profileModel: ProfileModel): Job {
        return viewModelScope.launch {
            val result = ProfilePutUseCase(ProfileRepository(Network.getInstance().getProfileApi())).invoke(profileModel)
            if (result.isSuccess) { }
            else cancel()
        }
    }

    fun logoutProfile(): Job{
        return viewModelScope.launch {
            val result = LogOutUseCase(AuthRepository(Network.getInstance().getAuthApi())).invoke()
            if (result.isSuccess) Network.getInstance().getTokenManager().deleteToken()
            else cancel()
        }
    }
}