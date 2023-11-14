package com.example.filmushits.view.screen.app_screen.ProfileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.Models.TokenModel
import com.example.filmushits.Network.Network
import com.example.filmushits.Network.Profile.ProfileRepository
import com.example.filmushits.Network.TokenManager
import com.example.filmushits.UseCases.ProfileGetUseCases
import com.example.filmushits.UseCases.ProfilePutUseCases
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel(){
    fun getProfile(): Deferred<ProfileModel?> {
        return viewModelScope.async {
            val result = ProfileGetUseCases(ProfileRepository(Network.getInstance().getProfileApi())).invoke()
            result.getOrNull()
        }
    }

    fun putProfile(profileModel: ProfileModel): Job {
        return viewModelScope.launch {
            val result = ProfilePutUseCases(ProfileRepository(Network.getInstance().getProfileApi())).invoke(profileModel)
            if (result.isSuccess) { }
            else cancel()
        }
    }
}