package com.example.filmushits.view.screen.log_reg_screen.RegScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import com.example.filmushits.Network.Auth.AuthRepository
import com.example.filmushits.Network.Network
import com.example.filmushits.UseCases.RegisterUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//class AuthViewModel: ViewModel() {
//    fun register(registerData: RegisterRequestBody): Job {
//        return viewModelScope.launch {
//            val result = RegisterUseCase(AuthRepository(Network.getInstance().getAuthApi))
//
//            if (result.isSuccess) Network.
//        }
//    }
//}